package lesson.j2ee.ex4;

import sun.util.locale.StringTokenIterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Banixc on 2016/10/24.
 */
public class ShoppingCartTag extends TagSupport {
    private String shoppingList;


    public int doStartTag() throws JspException {

        StringTokenIterator st = new StringTokenIterator(shoppingList, ",\b");

        JspWriter out = pageContext.getOut();

        String outPrint = "";

        while (st.hasNext()) {
            outPrint += st.next();
            outPrint += "<hr />";
        }
        try {
            out.print(outPrint);
        } catch (IOException e) {
            throw new JspTagException(e.getMessage());
        }

        return SKIP_BODY;
    }


    public String getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(String shoppingList) {
        this.shoppingList = shoppingList;
    }
}
