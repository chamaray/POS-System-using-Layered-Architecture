package lk.ijse.dep11;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep11.controller.CustomerController;
import lk.ijse.dep11.controller.ItemController;
import lk.ijse.dep11.controller.OrderController;
import lk.ijse.dep11.dto.CustomerDto;
import lk.ijse.dep11.dto.ItemDto;
import lk.ijse.dep11.dto.OrderDetailDto;
import lk.ijse.dep11.dto.OrderDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderViewController {
    public TextField txtOId;
    public TextField txtCustomerId;
    public Button btnSearchCust;
    public Label lblCustomer;
    public TextField txtItemId;
    public Button btnSearchItemId;
    public Label lblItemId;
    public TextField txtQty;
    public Button btnAdd;
    public TableView<OrderDto> tblOrder;
    public Button btnPlaceOrder;
    public Label lblTotal;

    private CustomerController customerController;
    private ItemController itemController;

    private ItemDto tempItemDto;
    private CustomerDto tempCustomerDto;
    private OrderController orderController;

    List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
    double total = 0.0;
    public void initialize(){
        customerController = new CustomerController();
        itemController = new ItemController();
        orderController = new OrderController();

        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemId"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("subTotal"));
    }

    public void btnSearchCustOnAction(ActionEvent actionEvent) {
        try {
            CustomerDto customerDto = customerController.getCustomer(Integer.valueOf(txtCustomerId.getText()));
            if(customerDto != null){
                tempCustomerDto = customerDto;
                lblCustomer.setText(customerDto.getName());
            }else {
                new Alert(Alert.AlertType.ERROR,"Please Enter valid Customer Id").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSearchItemIdOnAction(ActionEvent actionEvent) {
        try {
            ItemDto itemDto = itemController.getItem(Integer.valueOf(txtItemId.getText()));
            if(itemDto != null){
                tempItemDto = itemDto;
                lblItemId.setText("Name :"+itemDto.getName() + "| QOH :" + itemDto.getQOH() + "| Price"+itemDto.getUnitPrice());
            }else {
                new Alert(Alert.AlertType.ERROR,"Please Enter valid Item Id").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void btnAddOnAction(ActionEvent actionEvent) {
        ObservableList<OrderDto> orderList = tblOrder.getItems();
        if(tempItemDto != null){
            OrderDetailDto od = new OrderDetailDto(-1,tempItemDto.getId(),Integer.valueOf(txtQty.getText()),tempItemDto.getUnitPrice(),tempItemDto.getName());
            orderDetailDtos.add(od);
            orderList.add((OrderDto) orderDetailDtos);
            cleanItemData();
        }
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        OrderDto orderDto = new OrderDto(Integer.valueOf(txtOId.getText()),tempCustomerDto.getId(),new Date(),total,orderDetailDtos);
        try {
            String result = orderController.placeOrder(orderDto);
            new Alert(Alert.AlertType.INFORMATION,result).show();
        }catch(Exception e){
            e.printStackTrace();
        }
        cleanForm();
    }

    public void cleanItemData(){
        txtItemId.setText("");
        txtQty.setText("");
        tempItemDto =null;
        lblItemId.setText("");
    }
    public void cleanForm(){
        cleanItemData();
        tempCustomerDto = null;
        orderDetailDtos = new ArrayList<>();
        total = 0.0;
        txtOId.setText("");
        lblCustomer.setText("");
    }
}
