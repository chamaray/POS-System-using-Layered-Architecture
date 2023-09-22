package lk.ijse.dep11.dao;

import lk.ijse.dep11.dao.custom.impl.CustomerDaoImpl;

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
            default:
                return null;
        }
    }

    public enum DaoTypes{
        CUSTOMER
    }
}
