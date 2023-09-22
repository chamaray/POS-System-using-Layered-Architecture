package lk.ijse.dep11.service.custom.impl;

import lk.ijse.dep11.dao.DaoFactory;
import lk.ijse.dep11.dao.custom.CustomerDao;
import lk.ijse.dep11.dao.custom.ItemDao;
import lk.ijse.dep11.dto.CustomerDto;
import lk.ijse.dep11.dto.ItemDto;
import lk.ijse.dep11.entity.CustomerEntity;
import lk.ijse.dep11.entity.ItemEntity;
import lk.ijse.dep11.service.custom.ItemService;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);
    @Override
    public String addItem(ItemDto itemDto) throws Exception {
        if(itemDao.add(new ItemEntity(itemDto.getId(),itemDto.getName(),itemDto.getQtyOnHand(),itemDto.getUnitPrice()))){
            return  "Successfully Added";
        }else{
            return "Fail";
        }
    }

    @Override
    public String updateItem(ItemDto itemDto) throws Exception {
        if(itemDao.update(new ItemEntity(itemDto.getId(),itemDto.getName(),itemDto.getQtyOnHand(),itemDto.getUnitPrice()))){
            return  "Successfully Added";
        }else{
            return "Fail";
        }
    }

    @Override
    public String deleteItem(Integer id) throws Exception {
        if(itemDao.delete(id)){
            return "Successfully Deleted";
        }else{
            return "Fail";
        }
    }

    @Override
    public ItemDto getItem(Integer id) throws Exception {
        ItemEntity itemEntity = itemDao.get(id);
        return new ItemDto(itemEntity.getId(),itemEntity.getName(),itemEntity.getQtyOnHand(),itemEntity.getUnitPrice());
    }

    @Override
    public List<ItemDto> getAllItems() throws Exception {
        List<ItemDto> dtos = new ArrayList<>();
        List<ItemEntity> itemEntities = itemDao.getAll();

        for (ItemEntity itemEntity: itemEntities) {
            dtos.add(new ItemDto(itemEntity.getId(),itemEntity.getName(),itemEntity.getQtyOnHand(),itemEntity.getUnitPrice()));
        }
        return dtos;
    }
}
