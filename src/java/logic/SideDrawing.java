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
public class SideDrawing {

    private String SvgInlineSide;
    private int length;
    private int width;
    private int height;
    private int numberOfPoles;
    private int lengthOfDrawing;
    private int heightOfDrawing;
    private int firstPolePlacement;
    private int lastPolePlacement;
    private int centerPolePlacement;

    public String createSideView(String len, String wid, String hei)
    {

        PartCalculator pc = new PartCalculator();
        this.length = Integer.parseInt(len);
        this.width = Integer.parseInt(wid);
        this.height = Integer.parseInt(hei);
        this.numberOfPoles = pc.numbPoles(length);

        this.lengthOfDrawing = length + 200;
        this.heightOfDrawing = height + 100;
        this.firstPolePlacement = 45 + 20;
        this.lastPolePlacement = length - 45 + 20;
        this.centerPolePlacement = (length / 2) + 20;

        String svg1 = "<svg id='svg1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'\n"
                + lengthAndWidthOfDrawing()
                + surroundingSquare()
                + sidePoles()
                + roof()
                + sideStern()
                + textLength()
                + lengthLine()
                + textHeight()
                + "\n</svg>";
        return svg1;
    }

    public String createTopView()
    {
        String svg2 = "<svg id='svg2' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'\n"
                + lengthAndWidthOfDrawing()
                + surroundingSquare();
        return svg2;
    }

    private String textLength()
    {
        String textLength = "<text x='110' y='" + (heightOfDrawing - 10) + "'"
                + "style='fill:black;'>"
                + "længde: " + length
                + "</text>\n";
        //<text x="110" y="<%=pæle.get(0).getLength() + 80%>" style="fill:black;">
        //Længde: <%=pæle.get(1).getLength()%>cm
        //</text>
        return textLength;
    }

    private String lengthLine()
    {
        String line = "<line x1='20' y1='" + (heightOfDrawing - 30) + "' x2='" + (length + 20) + "' y2='" + (heightOfDrawing - 30) + "'"
                + "style='stroke:black;stroke-width:1;'/>";
        //<line  x1 = "20" y1 = "<%=pæle.get(0).getLength() + 60%>" x2 = "<%=length + 20%>" y2 = "<%=pæle.get(0).getLength() + 60%>" 
        //style = "stroke:black;stroke-width:1" / >
        return line;
    }

    private String textHeight()
    {
        String textHeight = "<text x='" + (length + 50) + "' y='40' style='fill:black'>"
                + "Højde:"
                + height
                + "</text>\n";

        //<text x="<%=pæle.get(1).getLength() + 50%>" y="40" style="fill:black;">
        //<%=height%>;
        return textHeight;
    }

    private String sideStern()
    {
        String sideStern = "<rect x='20' y='39' width ='" + length + "' height='15'\n"
                + "style='stroke:#000000;fill:white;'/>\n";
        return sideStern;

    }

    private String roof()
    {
        String roof = "<rect x='20' y='39' width='" + length + "' height='20'\n"
                + "style='stroke:#000000;fill:white;'/>\n";
        //<rect x="20" y="39" width="<%=pæle.get(1).getLength()%>" height="20"
        //1style="stroke: #000000; fill: white;"/>
        return roof;
    }

    private String centerPole()
    {
        String centerPole = "<rect x='" + centerPolePlacement + "' y='50' width='5' height='" + height + "'\n"
                + "style='stroke:#000000;fill:none;'/>\n";
        //<rect x="<%=centerPolePlacement + 20%>" y="50" width="5" height="<%=pæle.get(0).getLength()%>"
        //style="stroke: #000000; fill: none;"/>
        return centerPole;
    }

    private String sidePoles()
    {
        String poles = firstPole() + lastPole();
        if (moreThanTwoPoles(numberOfPoles))
        {
            poles += centerPole();
        }
        return poles;
    }

    private String surroundingSquare()
    {
        String ss = "<rect x='1' y='1' width='" + lengthOfDrawing + "' height='" + heightOfDrawing + "' "
                + "style='stroke:000000;fill:white;'/>\n";
        //<rect x="1" y="1" width="<%= pæle.get(1).getLength() + 98%>" height="<%=pæle.get(0).getLength() + 98%>"
        //style="stroke: #000000; fill: none;"/>
        return ss;
    }

    private String lengthAndWidthOfDrawing()
    {
        String lengthAndWidthOfDrawing = "width='100%'"
                + "viewbox='0,0," + lengthOfDrawing + "," + heightOfDrawing + "' preserveaspectratio='none'>\n";

//                 <svg id="svg1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
//                 width="<%=pæle.get(1).getLength() + 200%>"height="<%=pæle.get(0).getLength() + 200%>"
//                 viewbox="0, 0, <%=pæle.get(1).getLength() + 200%>, <%=pæle.get(0).getLength() + 200%>"
//                 preserveaspectratio="none">
        return lengthAndWidthOfDrawing;
    }

    private String firstPole()
    {
        String firstPole = "<rect x='" + firstPolePlacement + "' y='" + 50 + "' width='" + 5 + "' height='" + height + "'\n"
                + "style='stroke:#000000;fill:none;'/>\n";

        return firstPole;
    }

    private String lastPole()
    {
        String lastPole = "<rect x='" + lastPolePlacement + "' y='" + 50 + "' width='" + 5 + "' height ='" + height + "'\n"
                + "style='stroke:#000000;fill:none;'/>\n";
        return lastPole;
    }

    private boolean moreThanTwoPoles(int numberOfPoles)
    {
        if ((numberOfPoles / 2) > 2)
        {
            return true;
        }
        return false;
    }
}
