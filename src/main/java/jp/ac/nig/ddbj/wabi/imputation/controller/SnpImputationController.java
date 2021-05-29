package jp.ac.nig.ddbj.wabi.imputation.controller;


import jp.ac.nig.ddbj.wabi.imputation.form.SnpImputationForm;
import jp.ac.nig.ddbj.wabi.imputation.util.IdGenerator;
import jp.ac.nig.ddbj.wabi.imputation.json.JobInfo;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SnpImputationController {

    String baseDir = "/home/oogasawa/tmp/WabiImputation";

    ObjectMapper mapper = new ObjectMapper();



    public String createDirName(String jobId) {
        ArrayList<String> result = new ArrayList<String>();
        String[] jobDir = jobId.split("_");
        result.add(this.baseDir);

        for (int i = 0; i < jobDir.length; i++) {
            result.add(jobDir[i]);
        }

        return String.join("/", result);
    }


    public void createDirs(String jobId) {
        String dirName = this.createDirName(jobId);
        File dirObj = new File(dirName);

        if (!dirObj.exists()) {
            dirObj.mkdirs();
        }

    }


    @DeleteMapping("/wabi/SNP_imputation/{jobId}")
    public JobInfo deleteJob(@PathVariable String jobId) {
        JobInfo result = new JobInfo();
        result.setJobId(jobId);
        if (this.existsJobId(jobId)) {
            this.deleteJobDir(jobId);
            result.setState("deleted");
        } else {
            result.setState("not-found");
        }

        return result;
    }


    public boolean deleteJobDir(String jobId) {
        String dirName = this.createDirName(jobId);
        File dirObj = new File(dirName);
        return this.deleteDirectory(dirObj);
    }

    // https://www.baeldung.com/java-delete-directory
    boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                this.deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }



    public boolean existsJobId(String jobId) {
        String dirName = this.createDirName(jobId);
        File dirObj = new File(dirName);
        return dirObj.exists();
    }


    @GetMapping("/wabi/SNP_imputation/{jobId}/state")
    public JobInfo getJobState(@PathVariable String jobId) {
        JobInfo result = new JobInfo();
        result.setJobId(jobId);
        if (this.existsJobId(jobId)) {
            result.setState("initialized");
        }
        else {
            result.setState("not-found");
        }

        return result;
    }



    @PostMapping("/wabi/SNP_imputation")
    public JobInfo post(SnpImputationForm form) {
        JobInfo result = new JobInfo();
        String jobId = null;
        if (form.getJobId() == null) {
            jobId = IdGenerator.generate();
            result.setJobId(IdGenerator.generate());
            this.createDirs(jobId);
            result.setState("initialized");
        }
        else {
            jobId = form.getJobId();
        }


        return result;
    }




    @PostMapping("/wabi/SNP_imputation/{jobId}/file_upload")
    public JobInfo uploadFile(@PathVariable String jobId) {
        JobInfo result = new JobInfo();
        result.setJobId(jobId);
        if (this.existsJobId(jobId)) {
            this.deleteJobDir(jobId);
            result.setState("deleted");
        } else {
            result.setState("not-found");
        }

        return result;
    }





}
