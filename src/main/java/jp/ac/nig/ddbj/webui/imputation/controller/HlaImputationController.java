/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.nig.ddbj.webui.imputation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author oogasawa
 */
@Controller
public class HlaImputationController {
    @GetMapping("/HLA_imputation")
    public String getHlaImputation() {
        return "imputation/HLA_imputation";
    }
}
