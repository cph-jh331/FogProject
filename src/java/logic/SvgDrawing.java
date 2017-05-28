package logic;

import java.io.Serializable;

public class SvgDrawing implements Serializable {

    private int svgId;
    private String svgInline;
    private int customerId;
    private String dateCreated;
    private String dateAccepted;
    private boolean accepted = false;
    private int empId;
    private Status status;

    public enum Status {
        CREATED,
        REQAPPROVED,
        APPROVED,
        DONE,
    };

    /**
     * @return the status
     */
    public Status getStatus()
    {
        return status;
    }

    public String getStatusToString()
    {
        switch (status)
        {
            case REQAPPROVED:
                return "Sendt til Godkendelse";
            case APPROVED:
                return "Godkendt";
            case DONE:
                return "Afsluttet";
            default:
                return "Oprettet";
        }
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    public SvgDrawing(int svgId, String svgInline, int userId, String dateCreated, String dateAccepted, boolean accepted)
    {
        this.svgId = svgId;
        this.svgInline = svgInline;
        this.customerId = userId;
        this.dateCreated = dateCreated;
        this.dateAccepted = dateAccepted;
        this.accepted = accepted;
    }

    public SvgDrawing(int svgId, int customerId, String dateCreated, int empId, String dateAccept, String svgImage)
    {
        this.svgId = svgId;
        this.customerId = customerId;
        this.dateCreated = dateCreated;
        this.empId = empId;
        this.dateAccepted = dateAccept;
        this.svgInline = svgImage;

    }

    /**
     * @return the svgInline
     */
    public String getSvgInline()
    {
        return svgInline;
    }

    /**
     * @return the userId
     */
    public int getCustomerId()
    {
        return customerId;
    }

    /**
     * @return the accepted
     */
    public boolean isAccepted()
    {
        return accepted;
    }

    /**
     * @param svgInline the svgInline to set
     */
    public void setSvgInline(String svgInline)
    {
        this.svgInline = svgInline;
    }

    /**
     * @param customerId the userId to set
     */
    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }

    /**
     * @param accepted the accepted to set
     */
    public void setAccepted(boolean accepted)
    {
        this.accepted = accepted;
    }

    /**
     * @return the svgId
     */
    public int getSvgId()
    {
        return svgId;
    }

    /**
     * @return the dateCreated
     */
    public String getDateCreated()
    {
        return dateCreated;
    }

    /**
     * @return the dateAccepted
     */
    public String getDateAccepted()
    {
        return dateAccepted;
    }

}
