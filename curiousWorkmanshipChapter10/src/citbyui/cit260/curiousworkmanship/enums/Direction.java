/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.enums;

/**
 *
 * @author jacksonrkj
 */
public enum Direction {
    L("Left", 0, -1),
    R("Right", 0, 1),
    U("Up", -1, 0),
    D("Down", 1, 0);
    
    private final String value;
    private final int xIncrement;
    private final int yIncrement;

    private Direction(String name, int xIncrement, int yIncrement) {
        this.value = name;
        this.xIncrement = xIncrement;
        this.yIncrement = yIncrement;
    }

    public String getValue() {
        return value;
    }

    public int getxIncrement() {
        return xIncrement;
    }

    public int getyIncrement() {
        return yIncrement;
    }
    
    
    
}
