/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author User
 */
public class FormValidation {
    //validate value is empty 
    public static boolean textFieldNotEmpty(TextField i) {
        boolean r = false;
        if (i.getText() != null && !i.getText().isEmpty()) {
            r = true;
        }
        return r;
    }
    //validate value is integer 
    public static boolean isInt(TextField i) {
        try {
            int num = Integer.parseInt(i.getText());
            if(num==0){
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    //Combine validation for empty and integer
    public static boolean textFieldNotEmptyisInteger(TextField t, Label l) {
        boolean r = true;
        String c = null;
        if (!textFieldNotEmpty(t)) {
            r = false;
            c = "Empty! This is required!";
        } else if (!isInt(t)) {
            r = false;
            c = "Only integers are allowed!";
        }
        l.setText(c);
        return r;
    }
    //Point must greater than player!
    public static boolean pointPlayerNum(TextField point, TextField player, Label l){
        boolean r = true;
        int playerNum = Integer.parseInt(player.getText());
        int pointNum = Integer.parseInt(point.getText());
        String c = null;
        if(playerNum >= pointNum){
            r = false;
            c = "Point must greater than player!";
        }
        l.setText(c);
        return r;
    }
    
    public static boolean playerNumber(TextField t, Label l){
        boolean r = true;
        int playerNum = Integer.parseInt(t.getText());
        String c = null;
        if(playerNum>5){
            r = false;
            c = "Maximum 5 Players!";
        }
        l.setText(c);
        return r;
    }
}
