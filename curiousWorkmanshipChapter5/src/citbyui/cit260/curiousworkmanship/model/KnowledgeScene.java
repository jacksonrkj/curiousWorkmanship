/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

/**
 *
 * @author jacksonrkj
 */
public class KnowledgeScene extends Scene {
        
    private Question[] knowledgeQuestions;

    public KnowledgeScene() {
    }

    public KnowledgeScene( int sceneType, 
                           String description, 
                           String mapSymbol, 
                           double travelTime, 
                           boolean blocked, 
                           Question[] knowledgeQuestions) {
        super(sceneType, description, mapSymbol, travelTime, blocked);
        this.knowledgeQuestions = knowledgeQuestions;
    }

    public Question[] getKnowledgeQuestions() {
        return knowledgeQuestions;
    }

    public void setKnowledgeQuestions(Question[] knowledgeQuestions) {
        this.knowledgeQuestions = knowledgeQuestions;
    }
 
}
