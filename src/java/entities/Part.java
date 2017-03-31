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

}
