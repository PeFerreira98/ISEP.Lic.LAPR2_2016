/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.representante;

import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Keyword;

/**
 *
 * @author Sara Silva
 */
public class AddKeywordsController {

    private final Candidatura candidatura;

    public AddKeywordsController(Candidatura candidatura) {
        this.candidatura = candidatura;
    }

    public void addKeyword(String keyword) {
        candidatura.addKeyword(new Keyword(keyword));
    }
}
