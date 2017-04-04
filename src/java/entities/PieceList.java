package entities;

import fogInterfaces.PieceListInterface;
import java.util.HashMap;
import java.util.Map;

public class PieceList implements PieceListInterface {

    private HashMap<Integer, Part> pieceMap;

    public PieceList()
    {
        pieceMap = new HashMap<>();

        Part part = new Part("Stolpe", 0, 0, "stk", "en stolpe", 0);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Rem", 0, 0, "stk", "en rem", 1);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Spær", 0, 0, "stk", "et spær", 2);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Beslag Højre", null, 0, "stk", "et højresidet beslag", 3);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Beslag venstre", null, 0, "stk", "Et venstresidigt beslag", 4);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Hulbånd", 0, 0, "stk", "Et hulbånd", 5);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Overstern L", 0, 0, "stk", "overstern længde", 6);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Overstern B", 0, 0, "stk", "Overstern bredde", 7);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Understern L", 0, 0, "stk", "Understern længde", 8);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Understern B", 0, 0, "stk", "Understern bredde", 9);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Vandbræt L", 0, 0, "stk", "Vandbræt længde", 10);
        pieceMap.put(part.getPartId(), part);
        part = new Part("Vandbræt B", 0, 0, "stk", "Vandbræt bredde", 11);
        pieceMap.put(part.getPartId(), part);
    }

    public void updateParts(int length, int width, int height)
    {
        PartCalculator calc = new PartCalculator();
        //another way of doing it:
        //pieceMap.get(0).setLength(calc.lengthOfPole(height));
        //pieceMap.get(0).setPacketSize(length);

        Part part = pieceMap.get(0);
        part.setLength(calc.lengthOfPole(height));
        part.setPacketSize(calc.numbPoles(length));
        pieceMap.put(part.getPartId(), part);

        part = pieceMap.get(1);
        part.setLength(calc.lengthOfSideRafter(length));
        part.setPacketSize(calc.numbSideRafter(length));
        pieceMap.put(part.getPartId(), part);

        part = pieceMap.get(2);
        part.setLength(calc.lengthOfRafter(width));
        part.setPacketSize(calc.numbRafters(length));
        pieceMap.put(part.getPartId(), part);
    }

    public void getMap()
    {
        for (int i = 0; i < pieceMap.size(); i++)
        {
            System.out.println(pieceMap.get(i));
        }
    }

    @Override
    public void generatePieceList(int length, int width, int height)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, Part> getPieceMap()
    {
        return pieceMap;
    }
}
