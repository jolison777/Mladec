package com.test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements HttpSessionListener {

    static int total = 0, current = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        total++;
        current++;
        ServletContext ctx = se.getSession().getServletContext();
        ctx.setAttribute("tusers", total);
        ctx.setAttribute("cusers", current);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        current--;
        ServletContext ctx = se.getSession().getServletContext();
        ctx.setAttribute("cusers", current);
    }
}
