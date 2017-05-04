package logic;

public class SvgDrawing {

    private int svgId;
    private String svgInline;
    private int userId;
    private String dateCreated;
    private String dateAccepted;
    private boolean accepted = false;

    public SvgDrawing(int svgId, String svgInline, int userId, String dateCreated, String dateAccepted, boolean accepted)
    {
        this.svgId = svgId;
        this.svgInline = svgInline;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.dateAccepted = dateAccepted;
        this.accepted = accepted;
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
    public int getUserId()
    {
        return userId;
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
     * @param userId the userId to set
     */
    public void setUserId(int userId)
    {
        this.userId = userId;
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
