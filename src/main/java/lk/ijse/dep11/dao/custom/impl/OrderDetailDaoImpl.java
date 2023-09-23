package lk.ijse.dep11.dao.custom.impl;

import lk.ijse.dep11.dao.CrudUtil;
import lk.ijse.dep11.dao.custom.OrderDetailDao;
import lk.ijse.dep11.entity.OrderDetailEntity;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public boolean add(OrderDetailEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO order_Detail(order_id,item_id,unit_price,qty,sub_total) VALUES(?,?,?,?,?)",t.getOrder_id(),t.getItemId(),t.getUnitPrice(),t.getQty(),t.getQty()*t.getUnitPrice());
    }

    @Override
    public boolean update(OrderDetailEntity orderDetailEntity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetailEntity get(Integer integer) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<OrderDetailEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
