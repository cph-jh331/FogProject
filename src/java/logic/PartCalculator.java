package logic;

import fogInterfaces.PartCalculatorInterface;

public class PartCalculator implements PartCalculatorInterface {

    //alle "specielle" tal, som ikke kommer ind 
    //gennem et parameter burde nok være en
    //attribut i klassen?
    //With help of modolus we make sure that the number of poles are even.
    @Override
    public int numbPoles(int lengthOfCarport) {
        double numbPoles = ((double) lengthOfCarport / 230) * 2;

        if (numbPoles < 4) {
            return 4;
        } else {
            if ((int) numbPoles % 2 != 0) {
                numbPoles++;
            }
            return (int) numbPoles;
        }
    }

    //SKAL RETTES TIL:
    @Override
    public int numbSideRafter(int lengthOfCarport) {
        return 2;
    }

    @Override
    public int lengthOfSideRafter(int lengthOfCarport) {
        return lengthOfCarport;
    }

    @Override
    public int numbRafters(int lengthOfCarport) {
        int numbRafters = 1 + (lengthOfCarport / 55);
        return numbRafters;
    }

    @Override
    public int numbRightMounts(int numbRafters) {
        int numbRightMounts = numbRafters;
        return numbRightMounts;
    }

    @Override
    public int numbLeftMounts(int numbRafters) {
        int numbLeftMounts = numbRafters;
        return numbLeftMounts;
    }

    @Override
    public int lengthOfPole(int heightOfCarport) {
        int poleLength = heightOfCarport + 90;
        return poleLength;
    }

    @Override
    public int lengthOfRafter(int widthOfCarport) {
        return widthOfCarport;
    }

    @Override
    public int numbOfMetalTapes(int lengthOfCarport, int widthOfCarport) {
        double hul = Math.sqrt((Math.pow(lengthOfCarport - 55, 2)) + (Math.pow(widthOfCarport, 2)));
        double lengthOfTape = hul * 2;

        //920 is length minus 20 * 4 for backup in corners.
        if (lengthOfTape < 920) {
            return 1;
        } else if (lengthOfTape >= 920 && lengthOfTape < 1920) {
            return 2;
        }
        return 0;
    }

    @Override
    public int lengthUnderStern(int lengthOfCarport) {
        return lengthOfCarport;
    }

    @Override
    public int numbOfLengthUnderStern(int lengthUnderStern) {
        return 2;
    }

    @Override
    public int widthUnderStern(int widthOfCarport) {
        return widthOfCarport;
    }

    @Override
    public int numbOfWidthUnderStern(int widthUnderStern) {
        return 2;
    }

    @Override
    public int lengthOverStern(int lengthOfCarport) {
        return lengthOfCarport;
    }

    @Override
    public int numbOfLengthOverStern(int lengthOverStern) {
        return 2;
    }

    @Override
    public int widthOverStern(int widthOfCarport) {
        return widthOfCarport;
    }

    @Override
    public int numbOfWidthOverStern(int widthOverStern) {
        return 2;
    }

    @Override
    public int widthWaterBoard(int widthOfCarport) {
        return widthOfCarport;
    }

    @Override
    public int numbWidthWaterBoard(int widthWaterBoard) {
        return 1;
    }

    @Override
    public int lengthWaterBoard(int lengthOfCarport) {
        return lengthOfCarport;
    }

    @Override
    public int numbLengthWaterBoard(int lengthWaterBoard) {
        return 2;
    }

    public int numbOfTrapezScrews(int lengthOfCarport, int widthOfCarport) {

        int numbScrews = ((lengthOfCarport * widthOfCarport) / 100) * 12;
        if (numbScrews < 200) {
            return 1;
        } else if (numbScrews >= 200 || numbScrews < 400) {

            return 2;
        }
        return 0;
    }

    public int numbOfOverUnderScrews(int lengthOfCarport, int widthOfCarport) {
        int numbScrews = ((lengthOfCarport * widthOfCarport) / 100);
        if (numbScrews < 40) {
            return 1;
        } else {
            return 2;
        }
    }

    public int numbOfMountsScrews(int numbLeftMounts, int numbRafters) {
        int numbMountScrews = (numbLeftMounts * 2 * numbRafters) * 9 + 100;
        if (numbMountScrews < 250) {
            return 1;
        } else if (numbMountScrews >= 250 || numbMountScrews < 500) {
            return 2;
        } else {
            return 3;
        }

    }

    public int numbOfRafterBolts(int numbPoles) {

        return numbPoles;
    }

    public int rafterBoltsExtra(int numbPoles) {
        return numbPoles;
    }
}
