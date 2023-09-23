package lk.ijse.dep11.dao.custom.impl;

import lk.ijse.dep11.dao.CrudUtil;
import lk.ijse.dep11.dao.custom.OrderDao;
import lk.ijse.dep11.entity.OrderEntity;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean add(OrderEntity t) throws SQLException, ClassNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return CrudUtil.executeUpdate("INSERT INTO `order` VALUES(?,?,?,?)",t.getId(),t.getCustId(),sdf.format(t.getOrderDate()),t.getTotal());
    }

    @Override
    public boolean update(OrderEntity orderEntity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderEntity get(Integer integer) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<OrderEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
