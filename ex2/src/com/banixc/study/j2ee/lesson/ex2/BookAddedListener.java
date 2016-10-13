package com.banixc.study.j2ee.lesson.ex2;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class BookAddedListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent se) {
        out("added",se);
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
        out("removed",se);
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
        out("replaced",se);
    }

    private void out(String op,HttpSessionBindingEvent se){
        System.out.println("Attribute " + op + ": " + se.getName() + "(" + se.getValue() + ")");
    }
}
