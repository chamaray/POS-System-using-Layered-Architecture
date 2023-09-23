package lk.ijse.dep11.service.custom;

import lk.ijse.dep11.dto.OrderDto;
import lk.ijse.dep11.service.SuperService;

public interface OrderService extends SuperService {
    String placeOrder(OrderDto orderDto)throws Exception;
}
