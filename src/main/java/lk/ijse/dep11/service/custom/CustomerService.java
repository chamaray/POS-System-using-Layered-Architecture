package lk.ijse.dep11.service.custom;

import lk.ijse.dep11.dto.CustomerDto;
import lk.ijse.dep11.service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService {
    String addCustomer(CustomerDto customerDto) throws Exception;
    String updateCustomer(CustomerDto customerDto)throws Exception;
    String deleteCustomer(Integer id) throws Exception;
    CustomerDto getCustomer(Integer id)throws Exception;
    List<CustomerDto> getAllCustomers()throws Exception;
}
