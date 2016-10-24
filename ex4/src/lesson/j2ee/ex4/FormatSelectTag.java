package lesson.j2ee.ex4;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class FormatSelectTag extends TagSupport {
    private String selectList;
    public int doStartTag() throws JspException {

        StringTokenizer st = new StringTokenizer(selectList, ",\b");

        Map<String,Integer> map = new HashMap<String,Integer>();

        while(st.hasMoreTokens()){
            String select = st.nextToken();
            if(map.containsKey(select))
                map.put(select,map.get(select)+1);
            else
                map.put(select,1);
        }

        try {
        JspWriter out = pageContext.getOut();
        String outPrint = "";
        for (Map.Entry<String,Integer> entry:map.entrySet()
                ) {
            outPrint += entry.getKey();
            outPrint += " ";
            outPrint += entry.getValue();
            outPrint += "<hr />";
        }
        out.print(outPrint);
        } catch (IOException e) {
            throw new JspTagException(e.getMessage());
        }
        return SKIP_BODY;
    }


    public String getSelectList() {
        return selectList;
    }

    public void setSelectList(String selectList) {
        this.selectList = selectList;
    }
}
