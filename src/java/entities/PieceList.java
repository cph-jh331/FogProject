package entities;

import backend.PartMapper;
import fogInterfaces.PieceListInterface;
import java.util.HashMap;
import java.util.Map;

public class PieceList implements PieceListInterface {

    private HashMap<Integer, Part> woodMap;
    private HashMap<Integer, Part> roofMap;
    private HashMap<Integer, Part> miscMap;

    public PieceList()
    {
    }

    private void trapezRoof(int length, int width)
    {
        //tag antal
        int roofsForWidth = width / 100;

        length += 30;
        int numberOfRoofs;

        if (length >= 300 && (length - 30) < 570)
        {
            //roof på 600 meter
            numberOfRoofs = roofsForWidth * 1;
            getRoofMap().get(15).setPacketSize(numberOfRoofs);

        }
        if (length >= 570 && (length - 30) < 690)
        {
            //roof 2 på 360.
            numberOfRoofs = roofsForWidth * 2;
            getRoofMap().get(16).setPacketSize(numberOfRoofs);
        }

        if (length >= 690 && (length - 30) < 930)
        {
            //roof på 1 på 600, 1 på 360
            numberOfRoofs = roofsForWidth * 1;
            getRoofMap().get(15).setPacketSize(numberOfRoofs);
            getRoofMap().get(16).setPacketSize(numberOfRoofs);

        }
        if (length >= 930 && (length - 30) < 1170)
        {
            //roof 2 på 600 cm.
            numberOfRoofs = roofsForWidth * 2;
            getRoofMap().get(15).setPacketSize(numberOfRoofs);
        }
    }

    public void updateParts(int length, int width, int height)
    {
        PartCalculator calc = new PartCalculator();
        PartMapper partMapper = new PartMapper();
        woodMap = partMapper.getWoodParts();
        roofMap = partMapper.getRoofParts();
        miscMap = partMapper.getMiscParts();
        getWoodMap().get(11).setLengthAndPacketSize(calc.lengthOfPole(height), calc.numbPoles(length));
        getWoodMap().get(8).setLengthAndPacketSize(calc.lengthOfSideRafter(length), calc.numbSideRafter(length));
        getWoodMap().get(10).setLengthAndPacketSize(calc.lengthOfRafter(width), calc.numbRafters(length));
        trapezRoof(length, width);

    }

    //er der kun til at teste i main. Skal ændres eller fjernes helt senere.
//    public void getMap()
//    {
//        for (int i = 0; i < pieceMap.size(); i++)
//        {
//            System.out.println(pieceMap.get(i));
//        }
//    }
    @Override
    public void generatePieceList(int length, int width, int height)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public String printMap()
//    {
//        String str = "";
//        for (Map.Entry<Integer, Part> entry : pieceMap.entrySet())
//        {
//            if (entry.getValue().getPacketSize() != 0)
//            {
//                str += entry.getValue() + "\n";
//            }
//        }
//        return str;
//    }
    @Override
    public Map<Integer, Part> getPieceMap()
    {
        return null;
    }

    /**
     * @return the woodMap
     */
    public HashMap<Integer, Part> getWoodMap()
    {
        return woodMap;
    }

    /**
     * @return the roofMap
     */
    public HashMap<Integer, Part> getRoofMap()
    {
        return roofMap;
    }

    /**
     * @return the miscMap
     */
    public HashMap<Integer, Part> getMiscMap()
    {
        return miscMap;
    }

}
