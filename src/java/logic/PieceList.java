package logic;

import backend.DataFacade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PieceList {

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
            roofMap.get(2001).setPacketSize(numberOfRoofs);

        }
        if (length >= 570 && (length - 30) < 690)
        {
            //roof 2 på 360.
            numberOfRoofs = roofsForWidth * 2;
            roofMap.get(2002).setPacketSize(numberOfRoofs);
        }

        if (length >= 690 && (length - 30) < 930)
        {
            //roof på 1 på 600, 1 på 360
            numberOfRoofs = roofsForWidth * 1;
            roofMap.get(2001).setPacketSize(numberOfRoofs);
            roofMap.get(2002).setPacketSize(numberOfRoofs);

        }
        if (length >= 930 && (length - 30) < 1170)
        {
            //roof 2 på 600 cm.
            numberOfRoofs = roofsForWidth * 2;
            roofMap.get(2001).setPacketSize(numberOfRoofs);
        }
    }

    public void updateParts(int length, int width, int height)
    {
        PartCalculator calc = new PartCalculator();
        DataFacade dataFacade = new DataFacade();
        woodMap = dataFacade.getWoodMap();
        roofMap = dataFacade.getRoofMap();
        miscMap = dataFacade.getMiscMap();
        woodMap.get(1002).setLengthAndPacketSize(calc.lengthUnderStern(length), calc.numbOfLengthUnderStern(length));
        woodMap.get(1001).setLengthAndPacketSize(calc.widthUnderStern(width), calc.numbOfWidthUnderStern(width));
        woodMap.get(1004).setLengthAndPacketSize(calc.lengthOverStern(length), calc.numbOfLengthOverStern(length));
        woodMap.get(1003).setLengthAndPacketSize(calc.widthOverStern(width), calc.numbOfWidthOverStern(width));
        woodMap.get(1008).setLengthAndPacketSize(calc.lengthOfSideRafter(length), calc.numbSideRafter(length));
        woodMap.get(1010).setLengthAndPacketSize(calc.lengthOfRafter(width), calc.numbRafters(length));
        woodMap.get(1011).setLengthAndPacketSize(calc.lengthOfPole(height), calc.numbPoles(length));
        woodMap.get(1013).setLengthAndPacketSize(calc.lengthWaterBoard(length), calc.numbLengthWaterBoard(length));
        woodMap.get(1014).setLengthAndPacketSize(calc.widthWaterBoard(width), calc.numbWidthWaterBoard(width));
        miscMap.get(3003).setPacketSize(calc.numbRightMounts(woodMap.get(1010).getPacketSize()));
        miscMap.get(3004).setPacketSize(calc.numbOfMetalTapes(length, width));
        miscMap.get(3002).setPacketSize(calc.numbLeftMounts(woodMap.get(1010).getPacketSize()));
        miscMap.get(3005).setPacketSize(calc.numbOfOverUnderScrews(length, width));
        miscMap.get(3006).setPacketSize(calc.numbOfMountsScrews(miscMap.get(3004).getPacketSize(), woodMap.get(1010).getPacketSize()));
        miscMap.get(3007).setPacketSize(calc.numbOfRafterBolts(woodMap.get(1011).getPacketSize()));
        miscMap.get(3008).setPacketSize(calc.rafterBoltsExtra(woodMap.get(1011).getPacketSize()));
        trapezRoof(length, width);
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
