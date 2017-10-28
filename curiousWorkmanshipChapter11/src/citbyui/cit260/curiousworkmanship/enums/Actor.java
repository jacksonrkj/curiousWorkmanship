/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.enums;

import java.io.Serializable;

/**
 *
 * @author jacksonrkj
 */




public enum Actor implements Serializable {
    
    Lehi("He is the prophet and leader of the family."),
    Sariah("She is Lehi's wife and mother of the family."),
    Nephi("Faithful son and later the prophet leader of the Nephites."),
    Jacob("Nephi's faithful brother, prophet and successor to Nephi"),
    Sam("The youngest boy and faithful brother of Nephi."),
    Laman("The oldest rebellious brother and leader of the Lamanites."),
    Lemuel("The 2nd oldest rebellious brother who went with Laman"),
    Zoram("Laban servant that became a faithful follower of Nephi");
    
    private final String description;
    
    Actor(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }   
    
}
