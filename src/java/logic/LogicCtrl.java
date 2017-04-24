/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author bloch
 */
public class LogicCtrl {

    public boolean canParseString(String string)
    {
        try
        {
            Integer.parseInt(string);
        } catch (Exception illegalFormatException)
        {
            return false;
        }
        return true;
    }

}
