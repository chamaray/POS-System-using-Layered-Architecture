package lk.ijse.dep11.service.custom.impl;

import lk.ijse.dep11.dao.DaoFactory;
import lk.ijse.dep11.dao.custom.CustomerDao;
import lk.ijse.dep11.dto.CustomerDto;
import lk.ijse.dep11.entity.CustomerEntity;
import lk.ijse.dep11.service.custom.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.CUSTOMER);
    @Override
    public String addCustomer(CustomerDto customerDto) throws Exception {
        if(customerDao.add(new CustomerEntity(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),customerDto.getEmail(),customerDto.getPostalCode()))){
            return  "Successfully Added";
        }else{
            return "Fail";
        }
    }

    @Override
    public String updateCustomer(CustomerDto customerDto) throws Exception {
        if(customerDao.update(new CustomerEntity(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),customerDto.getEmail(),customerDto.getPostalCode()))){
            return  "Successfully Added";
        }else{
            return "Fail";
        }
    }

    @Override
    public String deleteCustomer(Integer id) throws Exception {
        if(customerDao.delete(id)){
            return "Successfully Deleted";
        }else{
            return "Fail";
        }
    }

    @Override
    public CustomerDto getCustomer(Integer id) throws Exception {
        CustomerEntity customerEntity = customerDao.get(id);
        return new CustomerDto(customerEntity.getId(),customerEntity.getName(),customerEntity.getAddress(),customerEntity.getEmail(),customerEntity.getPostal());
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws Exception {
        List<CustomerDto> dtos = new ArrayList<>();
        List<CustomerEntity> customerEntities = customerDao.getAll();

        for (CustomerEntity customerEntity: customerEntities) {
            dtos.add(new CustomerDto(customerEntity.getId(),customerEntity.getName(),customerEntity.getAddress(),customerEntity.getEmail(),customerEntity.getPostal()));
        }
        return dtos;
    }
}
