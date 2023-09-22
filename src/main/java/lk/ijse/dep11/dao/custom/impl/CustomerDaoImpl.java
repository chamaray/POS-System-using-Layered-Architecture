package lk.ijse.dep11.dao.custom.impl;

import lk.ijse.dep11.dao.custom.CustomerDao;
import lk.ijse.dep11.entity.CustomerEntity;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean add(CustomerEntity customerEntity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerEntity customerEntity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CustomerEntity get(Integer integer) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<CustomerEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
