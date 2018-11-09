package com.present.controller.reqhandler.commands;

import com.present.model.entities.present_items.IPresentItem;
import com.present.model.jdbc.DBConnection;
import com.present.model.jdbc.PresentItemDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yuliia Tesliuk on 11/07/2018
 */
public abstract class Command {
    protected ServletContext context;
    protected HttpServletRequest req;
    protected HttpServletResponse resp;
    protected HttpSession session;
    protected DBConnection db;
    protected PresentItemDAO itemDAO;
    protected List<IPresentItem> items;


    public void init(ServletContext context, HttpServletRequest req, HttpServletResponse resp) {
        this.context = context;
        this.req = req;
        this.resp = resp;
        this.session = req.getSession();
        db = new DBConnection();
    }

    public abstract void process() throws ServletException, IOException;

}
