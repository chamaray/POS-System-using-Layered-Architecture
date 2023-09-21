package lk.ijse.dep11.controller;

import lk.ijse.dep11.dto.CustomerDto;

import java.util.List;

public class CustomerController {

    public String addCustomer(CustomerDto customerDto)throws Exception{
        System.out.println(customerDto.toString());
        return null;
    }
    public String updateCustomer(CustomerDto customerDto)throws Exception{
        return  null;
    }
    public String deleteCustomer(Integer id)throws Exception{
        return null;
    }
    public CustomerDto getCustomer(Integer id)throws Exception{
        return  null;
    }
    public List<CustomerDto> getAllCustomer()throws Exception{
        return null;
    }
}
