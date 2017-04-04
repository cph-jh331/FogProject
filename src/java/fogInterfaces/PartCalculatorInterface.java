package fogInterfaces;

public interface PartCalculatorInterface {

    public int numbPoles(int lengthOfCarport);

    public int numbSideRafter(int lengthOfCarport);

    public int lengthOfSideRafter(int lengthOfCarport);

    public int numbRafters(int lengthOfCarport);
    
    public int lengthOfRafter(int widthOfCarport);

    public int numbRightMounts(int numbOfRafters);

    public int numbLeftMounts(int numbOfRafters);

    public int lengthOfPole(int heightOfCarport);

    public int numbOfMetalTapes(int lengthOfCarport, int widthOfCarport);

    public int lengthUnderStern(int lengthOfCaport);

    public int numbOfLengthUnderStern(int lengthUnderStern);

    public int widthUnderStern(int widthOfCarport);

    public int numbOfWidthUnderStern(int widthUnderStern);

    public int lengthOverStern(int lengthOfCarport);

    public int numbOfLengthOverStern(int lengthOverStern);

    public int widthOverStern(int widthOfCarport);

    public int numbOfWidthOverStern(int widthOverStern);

    public int widthWaterBoard(int widthOfCarport);

    public int numbWidthWaterBoard(int widthWaterBoard);

    public int lengthWaterBoard(int lengthOfCarport);

    public int numbLengthWaterBoard(int legnthWaterBoard);
}
