package com.present.model.jdbc;

import java.util.List;

/**
 * Created by Yuliia Tesliuk on 11/04/2018
 */
public interface PresentItemDAO<Entity, Key> {
    boolean create(Entity model);

    Entity read(Key key);

    List<Entity> readAll();

    boolean update(Entity model);

    boolean delete(Entity model);

}
