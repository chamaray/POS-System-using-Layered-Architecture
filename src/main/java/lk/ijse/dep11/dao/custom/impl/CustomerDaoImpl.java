package lk.ijse.dep11.dao.custom.impl;

import lk.ijse.dep11.dao.CrudUtil;
import lk.ijse.dep11.dao.custom.CustomerDao;
import lk.ijse.dep11.entity.CustomerEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean add(CustomerEntity t) throws SQLException, ClassNotFoundException {
       return CrudUtil.executeUpdate("INSERT INTO customer VALUES (?,?,?,?,?)",t.getId(),t.getName(),t.getAddress(),t.getEmail(),t.getPostal());
    }

    @Override
    public boolean update(CustomerEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE customer SET name=?,address=?,email=?,postal=? WHERE id=?",t.getName(),t.getAddress(),t.getEmail(),t.getPostal(),t.getId());
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM customer WHERE id=?",id);
    }

    @Override
    public CustomerEntity get(Integer id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM customer WHERE id=?",id);

        while(resultSet.next()){
            return new CustomerEntity(
                  resultSet.getInt("id"),
                  resultSet.getString("name"),
                  resultSet.getString("address"),
                  resultSet.getString("email"),
                  resultSet.getString("postal")
            );
        }
        return null;
    }

    @Override
    public List<CustomerEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM customer");
        List<CustomerEntity> customerEntities = new ArrayList<>();

        while(resultSet.next()){
            customerEntities.add(new CustomerEntity(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("email"),
                    resultSet.getString("postal")
            ));
        }
        return customerEntities;
    }
}
