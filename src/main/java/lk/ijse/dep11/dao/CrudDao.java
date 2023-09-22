package lk.ijse.dep11.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T, ID> extends SuperDao{
    boolean add(T t)throws SQLException,ClassNotFoundException;
    boolean update(T t)throws SQLException,ClassNotFoundException;
    boolean delete(ID id)throws SQLException,ClassNotFoundException;
    T get(ID id) throws SQLException,ClassNotFoundException;
    List<T> getAll() throws SQLException,ClassNotFoundException;
}
