package lk.ijse.dep11.service;

import lk.ijse.dep11.service.custom.impl.CustomerServiceImpl;
import lk.ijse.dep11.service.custom.impl.ItemServiceImpl;

public class ServiceFactory {

    private static  ServiceFactory serviceFactory;

    private ServiceFactory(){

    }
    public static ServiceFactory getServiceFactory(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType type){

        switch (type){
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType{
        CUSTOMER,ITEM
    }
}
