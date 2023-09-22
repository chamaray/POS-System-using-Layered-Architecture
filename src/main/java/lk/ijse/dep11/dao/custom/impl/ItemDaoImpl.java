package lk.ijse.dep11.dao.custom.impl;

import lk.ijse.dep11.dao.CrudUtil;
import lk.ijse.dep11.dao.custom.ItemDao;
import lk.ijse.dep11.entity.CustomerEntity;
import lk.ijse.dep11.entity.ItemEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean add(ItemEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES (?,?,?,?)",t.getId(),t.getName(),t.getQtyOnHand(),t.getUnitPrice());
    }

    @Override
    public boolean update(ItemEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE item SET name=?,qoh=?,unitPrice=? WHERE id=?",t.getName(),t.getQtyOnHand(),t.getUnitPrice(),t.getId());
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM item WHERE id=?",id);
    }

    @Override
    public ItemEntity get(Integer id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM item WHERE id=?",id);

        while(resultSet.next()){
            return new ItemEntity(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("qoh"),
                    resultSet.getDouble("unitPrice")
            );
        }
        return null;
    }

    @Override
    public List<ItemEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM item");
        List<ItemEntity> itemEntities = new ArrayList<>();

        while(resultSet.next()){
            itemEntities.add(new ItemEntity(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("qoh"),
                    resultSet.getDouble("unitPrice")
            ));
        }
        return itemEntities;
    }
}
