package lesson.j2ee.ex4;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class CounterTag extends TagSupport{
	
	private static int counter = 1;
	
	public int doStartTag()throws JspException{
		try{
		    JspWriter out = pageContext.getOut();      
		    out.print(counter);
		    setCounter();
		} catch (java.io.IOException e) {
		    throw new JspTagException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	public int getCounter()
	{
		return counter;
	}
	
	public void setCounter()
	{
		counter++;
	}
}
