package controller.servlets;

import controller.util.Util;
import model.entities.present_items.IPresentItem;
import model.entities.present_items.Sweety;
import model.entities.presents.CustomPresent;
import model.jdbc.DBConnection;
import model.jdbc.PresentItemDAO;
import model.jdbc.SweetyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yuliia Tesliuk on 11/05/2018
 */
@WebServlet("/constructor")
public class ConstructorServlet extends HttpServlet {
    private DBConnection dbConnection = new DBConnection();
    private PresentItemDAO<Sweety, String> itemDAO;
    private List<IPresentItem> sweeties;
    private CustomPresent present;

    @Override
    public void init() throws ServletException {
        itemDAO = new SweetyDAO(dbConnection.getConnection());
        sweeties = itemDAO.readAll().stream().map(x -> (IPresentItem) x).collect(Collectors.toList());
        present = new CustomPresent();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sweeties",sweeties);
        req.getRequestDispatcher("/WEB-INF/view/constructor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        double minSugar = Util.stringToDouble(req.getParameter("minSugar"),0);
        double maxSugar = Util.stringToDouble(req.getParameter("maxSugar"),Integer.MAX_VALUE);
        int minWeight = Util.stringToInt(req.getParameter("minWeight"),0);
        int maxWeight = Util.stringToInt(req.getParameter("maxWeight"),Integer.MAX_VALUE);
        int minPrice = (int) (Util.stringToDouble(req.getParameter("minPrice"),0) * 100);
        int maxPrice = (int) (Util.stringToDouble(req.getParameter("maxPrice"),Integer.MAX_VALUE) * 100);
        List<IPresentItem> filteredPresent = sweeties
                .stream()
                .filter(x -> (Util.isWithinBounds(x.getSugarContent(),minSugar,maxSugar) &&
                        Util.isWithinBounds(x.getWeight(),minWeight,maxWeight) &&
                        Util.isWithinBounds(x.getPrice(),minPrice,maxPrice)))
                .collect(Collectors.toList());


        req.setAttribute("sweeties", filteredPresent);
        req.getRequestDispatcher("/WEB-INF/view/constructor.jsp").forward(req, resp);
    }
}


