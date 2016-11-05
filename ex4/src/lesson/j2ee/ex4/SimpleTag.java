package lesson.j2ee.ex4;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Banixc on 2016/10/30.
 * SimpleTag:
 * 用于显示一个页面的访问次数 继承 SimpleTagSupport
 * 每调用一次该标签，次数+1
 */
public class SimpleTag extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(StatisticInfo.getCount());
    }
}
