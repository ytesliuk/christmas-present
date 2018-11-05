package model.jdbc;

import com.sun.istack.internal.NotNull;
import model.entities.present_items.IDSetter;
import model.entities.present_items.Sweety;

import java.lang.reflect.Method;
import java.sql.*;

/**
 * Created by Yuliia Tesliuk on 11/05/2018
 */
public class SweetyDAO implements PresentItemDAO<Sweety,String>
{
    private static final String CREATE = "INSERT INTO sweety (id, name, weight, sugarContent, price) VALUES ((?), (?), (?), (?), (?))";
    private static final String READ = "SELECT id FROM sweety WHERE name = (?)";
    private static final String UPDATE = "UPDATE sweety SET name =(?), weight =(?), sugarContent =(?), price = (?) WHERE id = (?)";
    private static final String DELETE = "DELETE FROM sweety WHERE name = (?) RETURNING id";


    private final Connection connection;

    public SweetyDAO (@NotNull final Connection connection){
        this.connection = connection;
    }

    @Override
    @IDSetter
    public boolean create(Sweety sweety) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,sweety.getID());
            statement.setString(2,sweety.getName());
            statement.setInt(3,sweety.getWeight());
            statement.setInt(4,sweety.getSugarContent());
            statement.setInt(5,sweety.getPrice());

            statement.execute();
            ResultSet resSet = statement.getGeneratedKeys();
            if(resSet.next()){
                sweety.setID(resSet.getInt("GENERATED_KEY"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }

    @Override
    public Sweety read(String name) {
        return null;
    }

    @Override
    public boolean update(Sweety sweety) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1,sweety.getName());
            statement.setInt(2,sweety.getWeight());
            statement.setInt(3,sweety.getSugarContent());
            statement.setInt(4,sweety.getPrice());
            statement.setInt(5,sweety.getID());

            return (statement.execute());

        } catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }

    @Override
    public boolean delete(Sweety sweety) {
        return false;
    }

}
