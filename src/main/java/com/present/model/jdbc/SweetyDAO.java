package com.present.model.jdbc;

import com.present.model.entities.present_items.IDSetter;
import com.present.model.entities.present_items.Sweety;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Yuliia Tesliuk on 11/05/2018
 */
public class SweetyDAO implements PresentItemDAO<Sweety,String> {
    private static final String CREATE = "INSERT INTO sweety (id, name, weight, sugarContent, price) VALUES ((?), (?), (?), (?), (?))";
    private static final String READ = "SELECT * FROM sweety WHERE name = (?)";
    private static final String UPDATE = "UPDATE sweety SET name =(?), weight =(?), sugarContent =(?), price = (?) WHERE id = (?)";
    private static final String DELETE = "DELETE FROM sweety WHERE id = (?)";

    private static final String READ_ALL = "SELECT * FROM sweety";



    private final Connection connection;

    public SweetyDAO(final Connection connection) {
        this.connection = connection;
    }

    @Override
    @IDSetter
    public boolean create(Sweety sweety) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, sweety.getID());
            statement.setString(2, sweety.getName());
            statement.setInt(3, sweety.getWeight());
            statement.setDouble(4, sweety.getSugarContent());
            statement.setInt(5, sweety.getPrice());

            statement.execute();
            ResultSet resSet = statement.getGeneratedKeys();
            if (resSet.next()) {
                sweety.setID(resSet.getInt("GENERATED_KEY"));
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @IDSetter
    @Override
    public Sweety read(String name){
        try {
            PreparedStatement statement = connection.prepareStatement(READ);
            statement.setString(1, name);

            statement.execute();
            ResultSet resSet = statement.getResultSet();
            if(resSet.next()) {
                int id = resSet.getInt("id");
                String sweetyName = resSet.getString("name");
                int weight = resSet.getInt("weight");
                double sugarContext = resSet.getDouble("sugarContent");
                int price = resSet.getInt("price");
                Sweety newSweety = new Sweety(sweetyName, weight, sugarContext, price);
                newSweety.setID(id);
                return newSweety;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @IDSetter
    public List<Sweety> readAll(){
        List<Sweety> sweeties = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.execute(READ_ALL);
            ResultSet resSet = statement.getResultSet();
            while(resSet.next()) {
                int id = resSet.getInt("id");
                String sweetyName = resSet.getString("name");
                int weight = resSet.getInt("weight");
                double sugarContext = resSet.getDouble("sugarContent");
                int price = resSet.getInt("price");
                Sweety newSweety = new Sweety(sweetyName, weight, sugarContext, price);
                newSweety.setID(id);
                sweeties.add(newSweety);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return sweeties;
    }

    @Override
    public boolean update(Sweety sweety) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1,sweety.getName());
            statement.setInt(2,sweety.getWeight());
            statement.setDouble(3,sweety.getSugarContent());
            statement.setInt(4,sweety.getPrice());
            statement.setInt(5,sweety.getID());

            return (statement.execute());

        } catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }

    @Override
    public boolean delete(Sweety sweety) throws NullPointerException {
        Objects.requireNonNull(sweety);
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1,sweety.getID());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
