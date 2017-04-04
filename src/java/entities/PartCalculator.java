package entities;

import fogInterfaces.PartCalculatorInterface;

public class PartCalculator implements PartCalculatorInterface {

    //With help of modolus we make sure that the number of poles are even.
    @Override
    public int numbPoles(int lengthOfCarport)
    {
        double numbPoles = ((double) lengthOfCarport / 230) * 2;

        if (numbPoles < 4)
        {
            return 4;
        } else
        {
            if ((int) numbPoles % 2 != 0)
            {
                numbPoles++;
            }
            return (int) numbPoles;
        }
    }

    //SKAL RETTES TIL:
    @Override
    public int numbSideRafter(int lengthOfCarport)
    {
        return 2;
    }

    @Override
    public int lengthOfSideRafter(int lengthOfCarport)
    {
        return lengthOfCarport;
    }

    @Override
    public int numbRafters(int lengthOfCarport)
    {
        int numbRafters = 1 + (lengthOfCarport / 55);
        return numbRafters;
    }

    @Override
    public int numbRightMounts(int numbRafters)
    {
        int numbRightMounts = numbRafters * 2;
        return numbRightMounts;
    }

    @Override
    public int numbLeftMounts(int numbRafters)
    {
        int numbLeftMounts = numbRafters * 2;
        return numbLeftMounts;
    }

    //skal laves om og flyttes til et andet sted, så vi kan få de rigtige
    // tage ud.
    public int numbTrapezRoof(int lengthOfCarport, int widthOfCarport)
    {
        int roofSize = lengthOfCarport * widthOfCarport;
        int numbOfRoofs = widthOfCarport / 100;

        if (numbOfRoofs % 2 != 0)
        {
            numbOfRoofs++;
        }

        lengthOfCarport += 30;

        if (lengthOfCarport > 300 && (lengthOfCarport - 30) < 570)
        {

        }
        if (lengthOfCarport > 570 && (lengthOfCarport - 30) < 690)
        {

        }
        if (lengthOfCarport > 690 && (lengthOfCarport - 30) < 930)
        {

        }
        if (lengthOfCarport > 930 && (lengthOfCarport - 30) < 1170)
        {

        }

        //Skal lave den til selve listen, så det er muligt, at vælge forskellige tage.
        return 0;
    }

    @Override
    public int lengthOfPole(int heightOfCarport)
    {
        int poleLength = heightOfCarport + 90;
        return poleLength;
    }

    @Override
    public int lengthOfRafter(int widthOfCarport)
    {
        return widthOfCarport;
    }

    @Override
    public int numbOfMetalTapes(int lengthOfCarport, int widthOfCarport)
    {
        double hul = Math.sqrt((Math.pow(lengthOfCarport - 55, 2)) + (Math.pow(widthOfCarport, 2)));
        double lengthOfTape = hul * 2;

        //920 is length minus 20 * 4 for backup in corners.
        if (lengthOfTape < 920)
        {
            return 1;
        } else if (lengthOfTape >= 920 && lengthOfTape < 1920)
        {
            return 2;
        }
        return 0;
    }

    @Override
    public int lengthUnderStern(int lengthOfCarport)
    {
        return lengthOfCarport;
    }

    @Override
    public int numbOfLengthUnderStern(int lengthUnderStern)
    {
        return 2;
    }

    @Override
    public int widthUnderStern(int widthOfCarport)
    {
        return widthOfCarport;
    }

    @Override
    public int numbOfWidthUnderStern(int widthUnderStern)
    {
        return 2;
    }

    @Override
    public int lengthOverStern(int lengthOfCarport)
    {
        return lengthOfCarport;
    }

    @Override
    public int numbOfLengthOverStern(int lengthOverStern)
    {
        return 2;
    }

    @Override
    public int widthOverStern(int widthOfCarport)
    {
        return widthOfCarport;
    }

    @Override
    public int numbOfWidthOverStern(int widthOverStern)
    {
        return 2;
    }

    @Override
    public int widthWaterBoard(int widthOfCarport)
    {
        return widthOfCarport;
    }

    @Override
    public int numbWidthWaterBoard(int widthWaterBoard)
    {
        return 1;
    }

    @Override
    public int lengthWaterBoard(int lengthOfCarport)
    {
        return lengthOfCarport;
    }

    @Override
    public int numbLengthWaterBoard(int legnthWaterBoard)
    {
        return 2;
    }

}
