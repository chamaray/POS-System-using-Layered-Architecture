package lk.ijse.dep11.service.custom.impl;

import lk.ijse.dep11.dao.DaoFactory;
import lk.ijse.dep11.dao.custom.ItemDao;
import lk.ijse.dep11.dao.custom.OrderDao;
import lk.ijse.dep11.dao.custom.OrderDetailDao;
import lk.ijse.dep11.db.DbConnection;
import lk.ijse.dep11.dto.OrderDetailDto;
import lk.ijse.dep11.dto.OrderDto;
import lk.ijse.dep11.entity.ItemEntity;
import lk.ijse.dep11.entity.OrderDetailEntity;
import lk.ijse.dep11.entity.OrderEntity;
import lk.ijse.dep11.service.custom.OrderService;

import java.sql.Connection;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);
    @Override
    public String placeOrder(OrderDto orderDto) throws Exception {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try{
            if(orderDao.add(new OrderEntity(orderDto.getId(),orderDto.getCustId(),orderDto.getOrderDate(),orderDto.getTotal()))){
                boolean isOrderDetailSaved = true;

                for(OrderDetailDto detailDto:orderDto.getOrderDetailDtos()){
                    if(!(orderDetailDao.add(new OrderDetailEntity(-1,detailDto.getItemId(),orderDto.getId(),detailDto.getQty(),detailDto.getUnitPrice(),detailDto.getName())))){
                        isOrderDetailSaved = false;
                    }
                }

                if(isOrderDetailSaved){
                    boolean isItemUpdated = true;
                    for(OrderDetailDto detailDto:orderDto.getOrderDetailDtos()){
                        ItemEntity entity = itemDao.get(detailDto.getItemId());
                        entity.setQtyOnHand(entity.getQtyOnHand() -detailDto.getQty());
                        if(!(itemDao.update(entity))){
                            isItemUpdated = false;
                        }

                    }
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    }else{
                        connection.rollback();
                        return "Item Updated Error";
                    }
                }else{
                    connection.rollback();
                    return "Order Details Save Error";
                }

            }else{
                connection.rollback();
                return "Order save Error";
            }
        }catch(Exception e){
            connection.rollback();
            throw e;
        }finally{
            connection.setAutoCommit(true);
        }
    }
}
