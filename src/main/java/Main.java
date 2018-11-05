import model.entities.present_items.Sweety;
import model.jdbc.DBConnection;
import model.jdbc.SweetyDAO;

/**
 * Created by Yuliia Tesliuk on 11/02/2018
 */
public class Main {
    public static void main(String[] args){
        DBConnection dbConnection = new DBConnection();

        if(dbConnection.isConnected()) {

        }
        SweetyDAO sweety = new SweetyDAO(dbConnection.getConnection());

        Sweety newSweety = new Sweety("Белочка51", 40, 10, 1500);
        Sweety newSweety2 = new Sweety("Белочка52", 40, 10, 1500);
        Sweety newSweety3 = new Sweety("Белочка53", 40, 10, 1500);

        System.out.println(newSweety.toString());

        sweety.create(newSweety);
        sweety.create(newSweety2);
        sweety.create(newSweety3);



        newSweety.setSugarContent(5);
        sweety.update(newSweety);

    }
}
