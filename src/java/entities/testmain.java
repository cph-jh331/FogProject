/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bloch
 */
public class testmain {
    
    public static void main(String[] args)
    {
        PartCalculator calc = new PartCalculator();
        //System.out.println(calc.numbPoles(600));      
//        
//        double numberSke = Math.sqrt(5*5);
//        System.out.println(numberSke);
        PieceList pl = new PieceList();
        pl.updateParts(500, 500, 300);
        //pl.getMap();
        
    }
    
}
