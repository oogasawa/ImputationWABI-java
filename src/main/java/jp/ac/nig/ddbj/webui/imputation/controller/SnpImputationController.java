/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.nig.ddbj.webui.imputation.controller;

import java.util.Locale;
// import jp.ac.nig.ddbj.imputation.form.SnpImputationForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author oogasawa
 */
@Controller
@Slf4j
public class SnpImputationController {

    @GetMapping("/SNP_imputation")
    public String getSnpImputation() {

        return "imputation/SNP_imputation";
    }

    /*
    @PostMapping("/SNP_imputation")
    public String postSnpImputation(Model model, Locale locale,
            @ModelAttribute SnpImputationForm form) {

        // log.info("form.getPlinkFile(): " + form.getPlinkFile());
        // log.info("form.getGenomicAssembly(): " + form.getGenomicAssembly());
        // log.info("form.getPopulatonModel()" + form.getPopulationModel());

        return "imputation/SNP_imputation";
    }
    */

}

