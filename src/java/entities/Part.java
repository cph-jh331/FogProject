/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import fogInterfaces.PartInterface;

/**
 *
 * @author bloch
 */
public class Part implements PartInterface {

    private String type;
    private Integer length;
    private int packetSize;
    private String unitName;
    private String desc;
    private int partId;
    private String category;

    public Part(String type, Integer length, int packetSize, String unitName, String desc, int partId, String category)
    {
        this.type = type;
        this.length = length;
        this.packetSize = packetSize;
        this.unitName = unitName;
        this.desc = desc;
        this.partId = partId;
        this.category = category;
    }

    @Override
    public String getType()
    {
        return this.type;
    }

    @Override
    public Integer getLength()
    {
        return this.length;
    }

    @Override
    public int getPacketSize()
    {
        return this.packetSize;
    }

    @Override
    public String getUnitName()
    {
        return this.unitName;
    }

    @Override
    public String getDescription()
    {
        return this.desc;
    }

    @Override
    public int getPartId()
    {
        return this.partId;
    }

    /**
     * @param length the length to set
     */
    @Override
    public void setLength(Integer length)
    {
        this.length = length;
    }

    /**
     * @param packetSize the packetSize to set
     */
    @Override
    public void setPacketSize(int packetSize)
    {
        this.packetSize = packetSize;
    }

    public void setLengthAndPacketSize(Integer length, int packetSize)
    {
        this.length = length;
        this.packetSize = packetSize;
    }

    @Override
    public String toString()
    {
        return "Part{" + "type=" + type + ", length=" + length + ", packetSize=" + packetSize + ", unitName=" + unitName + ", desc=" + desc + ", partId=" + partId + '}';
    }

    /**
     * @return the category
     */
    public String getCategory()
    {
        return category;
    }

}
