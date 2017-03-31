package fogInterfaces;

import entities.Part;
import java.util.Map;

public interface PartListInterface {

    public void generatePieceList(int length, int width);

    public Map<Integer, Part> getPieceList();

}
