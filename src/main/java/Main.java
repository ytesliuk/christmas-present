import model.entities.present_items.Sweety;
import model.jdbc.DBConnection;
import model.jdbc.SweetyDAO;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Yuliia Tesliuk on 11/02/2018
 */
public class Main {
    public static void main(String[] args){
        DBConnection dbConnection = new DBConnection();

        if(dbConnection.isConnected()) {

        }
        SweetyDAO sweety = new SweetyDAO(dbConnection.getConnection());

        Sweety newSweety = new Sweety("Белочка", 40, 10, 1500);
        Sweety newSweety2 = new Sweety("Белочка", 40, 10, 1500);
        Sweety newSweety3 = new Sweety("Белочка", 40, 10, 1500);



//
        sweety.create(newSweety);
        sweety.create(newSweety2);
        sweety.create(newSweety3);

        System.out.println(newSweety.toString());
        System.out.println(newSweety2.toString());
        System.out.println(newSweety3.toString());

//
//        newSweety.setSugarContent(5);
//        sweety.update(newSweety);

        try {
            Optional<Sweety> sweety2 = Optional.ofNullable(sweety.read("Белочка"));
            sweety2.ifPresent(sweety::delete);


        } catch (SQLException e) {
            System.out.println("not found");
        }


    }
}
