package lk.ijse.dep11.controller;

import lk.ijse.dep11.dto.OrderDto;
import lk.ijse.dep11.service.ServiceFactory;
import lk.ijse.dep11.service.custom.OrderService;

public class OrderController {
    OrderService orderService = (OrderService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.ORDER);
    public String placeOrder(OrderDto orderDto) throws Exception {
        return orderService.placeOrder(orderDto);
    }
}
