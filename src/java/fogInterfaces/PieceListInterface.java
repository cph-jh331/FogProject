package fogInterfaces;

import entities.Part;
import java.util.Map;

public interface PieceListInterface {

    public void generatePieceList(int length, int width, int height);

    public Map<Integer, Part> getPieceMap();

}
