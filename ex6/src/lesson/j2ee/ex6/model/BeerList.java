package lesson.j2ee.ex6.model;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by Banixc on 2016/11/5.
 */
public class BeerList extends SimpleTagSupport {
    private String color;

    public void doTag() throws JspException, IOException {
        List<BeerItem> beers;
        BeerExpert be = new BeerExpert();
        beers = (List<BeerItem>) be.getBrands(color);
        String outPrint = "";
        for (BeerItem beer:beers) {
            JspWriter out = getJspContext().getOut();
            outPrint += String.format("<tr><td width=\"69\"><input type=\"checkbox\" name=\"item\" value=\"%s\"></td><td width=\"431\">Item%d: %s</td></tr>",beer.getAllName(),beer.getId(),beer.getAllName());
        }
        JspWriter out = getJspContext().getOut();
        out.print(outPrint);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
