package model.jdbc;

import java.sql.SQLException;

/**
 * Created by Yuliia Tesliuk on 11/04/2018
 */
public interface PresentItemDAO<Entity, Key> {
    boolean create(Entity model);

    Entity read(Key key) throws SQLException;

    boolean update(Entity model);

    boolean delete(Entity model);

}
