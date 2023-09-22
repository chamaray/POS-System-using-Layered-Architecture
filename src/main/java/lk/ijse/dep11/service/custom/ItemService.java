package lk.ijse.dep11.service.custom;

import lk.ijse.dep11.dto.CustomerDto;
import lk.ijse.dep11.dto.ItemDto;
import lk.ijse.dep11.service.SuperService;

import java.util.List;

public interface ItemService extends SuperService {
    String addItem(ItemDto itemDto) throws Exception;
    String updateItem(ItemDto itemDto)throws Exception;
    String deleteItem(Integer id) throws Exception;
    ItemDto getItem(Integer id)throws Exception;
    List<ItemDto> getAllItems()throws Exception;
}
