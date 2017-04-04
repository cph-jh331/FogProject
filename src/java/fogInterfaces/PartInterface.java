package fogInterfaces;

public interface PartInterface {

    public String getType();

    public Integer getLength();

    public int getPacketSize();

    public String getUnitName();

    public String getDescription();

    public int getPartId();

    public void setLength(Integer length);

    public void setPacketSize(int packetSize);

}
