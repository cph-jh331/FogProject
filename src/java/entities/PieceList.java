package entities;

import backend.PartMapper;
import fogInterfaces.PieceListInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            roofMap.get(15).setPacketSize(numberOfRoofs);

        }
        if (length >= 570 && (length - 30) < 690)
        {
            //roof 2 på 360.
            numberOfRoofs = roofsForWidth * 2;
            roofMap.get(16).setPacketSize(numberOfRoofs);
        }

        if (length >= 690 && (length - 30) < 930)
        {
            //roof på 1 på 600, 1 på 360
            numberOfRoofs = roofsForWidth * 1;
            roofMap.get(15).setPacketSize(numberOfRoofs);
            roofMap.get(16).setPacketSize(numberOfRoofs);

        }
        if (length >= 930 && (length - 30) < 1170)
        {
            //roof 2 på 600 cm.
            numberOfRoofs = roofsForWidth * 2;
            roofMap.get(15).setPacketSize(numberOfRoofs);
        }
    }

    public void updateParts(int length, int width, int height)
    {
        PartCalculator calc = new PartCalculator();
        PartMapper partMapper = new PartMapper();
        woodMap = partMapper.getWoodParts();
        roofMap = partMapper.getRoofParts();
        miscMap = partMapper.getMiscParts();
        woodMap.get(1).setLengthAndPacketSize(calc.lengthUnderStern(length), calc.numbOfLengthUnderStern(length));
        woodMap.get(2).setLengthAndPacketSize(calc.widthUnderStern(width), calc.numbOfWidthUnderStern(width));
        woodMap.get(3).setLengthAndPacketSize(calc.lengthOverStern(length), calc.numbOfLengthOverStern(length));
        woodMap.get(4).setLengthAndPacketSize(calc.widthOverStern(width), calc.numbOfWidthOverStern(width));
        woodMap.get(8).setLengthAndPacketSize(calc.lengthOfSideRafter(length), calc.numbSideRafter(length));
        woodMap.get(10).setLengthAndPacketSize(calc.lengthOfRafter(width), calc.numbRafters(length));
        woodMap.get(11).setLengthAndPacketSize(calc.lengthOfPole(height), calc.numbPoles(length));
        woodMap.get(13).setLengthAndPacketSize(calc.lengthWaterBoard(length), calc.numbLengthWaterBoard(length));
        woodMap.get(14).setLengthAndPacketSize(calc.widthWaterBoard(width), calc.numbWidthWaterBoard(width));
        miscMap.get(19).setPacketSize(calc.numbRightMounts(woodMap.get(10).getPacketSize()));
        miscMap.get(20).setPacketSize(calc.numbLeftMounts(woodMap.get(10).getPacketSize()));
        miscMap.get(18).setPacketSize(calc.numbOfMetalTapes(length, width));
        trapezRoof(length, width);

//        int længdeAfStolpe = calc.lengthOfPole(height);
//        int antalAfStolpe = calc.numbPoles(length);
//        Part stolpe = woodMap.get(11);
//        stolpe.setLength(længdeAfStolpe);
//        stolpe.setPacketSize(antalAfStolpe);   
    }

    @Override
    public void generatePieceList(int length, int width, int height)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, Part> getPieceMap()
    {
        return null;
    }
    
    public List<Part> getWoodList()
    {
        List<Part> partList = new ArrayList<>();
        for (Map.Entry<Integer, Part> entry : woodMap.entrySet())
        {
            if (entry.getValue().getPacketSize() != 0)
            {
                partList.add(entry.getValue());
            }
        }
        return partList;
    }

    public List<Part> getRoofList()
    {
        List<Part> partList = new ArrayList<>();
        for (Map.Entry<Integer, Part> entry : roofMap.entrySet())
        {
            if (entry.getValue().getPacketSize() != 0)
            {
                partList.add(entry.getValue());
            }
        }
        return partList;
    }
    //returns a list with the misc.
    public List<Part> getMiscList()
    {
        List<Part> partList = new ArrayList<>();
        for (Map.Entry<Integer, Part> entry : miscMap.entrySet())
        {

            if (entry.getValue().getPacketSize() != 0)
            {
                partList.add(entry.getValue());
            }
        }
        return partList;
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
