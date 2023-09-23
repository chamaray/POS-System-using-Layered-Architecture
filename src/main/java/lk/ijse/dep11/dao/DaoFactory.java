package lk.ijse.dep11.dao;

import lk.ijse.dep11.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.dep11.dao.custom.impl.ItemDaoImpl;
import lk.ijse.dep11.dao.custom.impl.OrderDaoImpl;
import lk.ijse.dep11.dao.custom.impl.OrderDetailDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}

    public static DaoFactory getDaoFactory(){
        if(daoFactory ==null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAIL:
                return new OrderDetailDaoImpl();
            default:
                return null;
        }
    }

    public enum DaoTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }
}
