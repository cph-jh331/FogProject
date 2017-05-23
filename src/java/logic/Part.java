/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author bloch
 */
public class Part {

    private String type;
    private Integer length;
    private int packetSize;
    private String unitName;
    private String desc;
    private int partId;
    private String category;
    private String typeCategory;

    public Part(String type, String unitName, String desc, String category, String typeCategory) {
        this.type = type;
        this.unitName = unitName;
        this.desc = desc;
        this.category = category;
        this.typeCategory = typeCategory;
    }

    public Part(String type, Integer length, int packetSize, String unitName, String desc, int partId, String category, String typeCategory) {
        this.type = type;
        this.length = length;
        this.packetSize = packetSize;
        this.unitName = unitName;
        this.desc = desc;
        this.partId = partId;
        this.category = category;
        this.typeCategory = typeCategory;
    }

    public String getTypeCategory() {
        return typeCategory;
    }

    public String getType() {
        return this.type;
    }

    public Integer getLength() {
        return this.length;
    }

    public int getPacketSize() {
        return this.packetSize;
    }

    public String getUnitName() {
        return this.unitName;
    }

    public String getDescription() {
        return this.desc;
    }

    public int getPartId() {
        return this.partId;
    }

    /**
     * @param length the length to set
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * @param packetSize the packetSize to set
     */
    public void setPacketSize(int packetSize) {
        this.packetSize = packetSize;
    }

    public void setLengthAndPacketSize(Integer length, int packetSize) {
        this.length = length;
        this.packetSize = packetSize;
    }

    @Override
    public String toString() {
        return "Part{" + "type=" + type + ", length=" + length + ", packetSize=" + packetSize + ", unitName=" + unitName + ", desc=" + desc + ", partId=" + partId + '}';
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

}
