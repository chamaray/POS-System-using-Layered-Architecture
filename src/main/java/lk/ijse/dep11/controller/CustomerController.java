package lk.ijse.dep11.controller;

import lk.ijse.dep11.dto.CustomerDto;
import lk.ijse.dep11.service.ServiceFactory;
import lk.ijse.dep11.service.custom.CustomerService;

import java.util.List;

public class CustomerController {
    CustomerService customerService = (CustomerService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.CUSTOMER);
    public String addCustomer(CustomerDto customerDto)throws Exception{
        return customerService.addCustomer(customerDto);
    }
    public String updateCustomer(CustomerDto customerDto)throws Exception{
        return customerService.updateCustomer(customerDto);
    }
    public String deleteCustomer(Integer id)throws Exception{
        return customerService.deleteCustomer(id);
    }
    public CustomerDto getCustomer(Integer id)throws Exception{
        return customerService.getCustomer(id);
    }
    public List<CustomerDto> getAllCustomer()throws Exception{
        return customerService.getAllCustomers();
    }
}
