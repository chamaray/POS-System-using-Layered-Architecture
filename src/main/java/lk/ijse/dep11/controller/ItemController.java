package lk.ijse.dep11.controller;

import lk.ijse.dep11.dto.CustomerDto;
import lk.ijse.dep11.dto.ItemDto;
import lk.ijse.dep11.service.ServiceFactory;
import lk.ijse.dep11.service.custom.CustomerService;
import lk.ijse.dep11.service.custom.ItemService;

import java.util.List;

public class ItemController {

    ItemService itemService = (ItemService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.ITEM);
    public String addItem(ItemDto itemDto)throws Exception{
        return itemService.addItem(itemDto);
    }
    public String updateItem(ItemDto itemDto)throws Exception{
        return itemService.updateItem(itemDto);
    }
    public String deleteItem(Integer id)throws Exception{
        return itemService.deleteItem(id);
    }
    public ItemDto getItem(Integer id)throws Exception{
        return itemService.getItem(id);
    }
    public List<ItemDto> getAllItem()throws Exception{
        return itemService.getAllItems();
    }
}
