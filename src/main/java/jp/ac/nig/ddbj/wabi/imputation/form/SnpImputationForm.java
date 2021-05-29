package jp.ac.nig.ddbj.wabi.imputation.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 *
 * @author oogasawa
 */
@Data
public class SnpImputationForm {

    private MultipartFile plinkFile;
    private String genomicAssembly;
    private String populationModel;
    private String genotypingPlatform;
    private String outputFormat;

    private String jobId;
}
