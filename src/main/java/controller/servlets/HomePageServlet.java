package controller.servlets;

import model.entities.present_items.Sweety;
import model.jdbc.DBConnection;
import model.jdbc.PresentItemDAO;
import model.jdbc.SweetyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Yuliia Tesliuk on 11/05/2018
 */
@WebServlet("")
public class HomePageServlet extends HttpServlet {
    private DBConnection dbConnection = new DBConnection();
    private PresentItemDAO<Sweety,String> itemDAO;
    private List<Sweety> sweeties;

    @Override
    public void init() throws ServletException {
        itemDAO = new SweetyDAO(dbConnection.getConnection());
        sweeties = itemDAO.readAll();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sweeties",sweeties);
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        createSweety(req,resp);
        doGet(req,resp);
    }

    private void createSweety(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("name");
        int weight = Integer.parseInt(req.getParameter("weight"));
        double sugarContent = Double.parseDouble(req.getParameter("sugarContent"));
        int price = (int) (Double.parseDouble(req.getParameter("price")) * 100);

        Sweety newSweety = new Sweety(name, weight, sugarContent, price);
        itemDAO.create(newSweety);
        sweeties.add(newSweety);
    }

}
