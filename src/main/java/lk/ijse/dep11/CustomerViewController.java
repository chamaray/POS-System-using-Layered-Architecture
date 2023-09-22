package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.dep11.controller.CustomerController;
import lk.ijse.dep11.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public class CustomerViewController {
    public TextField txtCustomerId;
    public TextField txtCustomerName;
    public TextField txtCustomerEmail;
    public TextField txtCustomerAddress;
    public TextField txtCustomerPostal;
    public Button btnAddCustomer;
    public Button btnUpdateCustomer;
    public Button btnDeleteCustomer;
    public TableView<CustomerDto> tblCustomer;


    private CustomerController customerController;
    public void initialize(){
    customerController = new CustomerController();

        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblCustomer.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tblCustomer.getSelectionModel().setCellSelectionEnabled(true);
    }

    public void txtIdOnAction(ActionEvent actionEvent) {
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
    }

    public void txtPostalCodeOnAction(ActionEvent actionEvent) {
    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtCustomerId.getText());
        CustomerDto customerDto = new CustomerDto(id,txtCustomerName.getText(),txtCustomerAddress.getText(),txtCustomerEmail.getText(),txtCustomerPostal.getText());
        try {
            String result = customerController.addCustomer(customerDto);
            new Alert(Alert.AlertType.INFORMATION,result).show();
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearForm();
        loadAllCustomers();
    }

    public void btnUpdateCustomerOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtCustomerId.getText());
        CustomerDto customerDto = new CustomerDto(id,txtCustomerName.getText(),txtCustomerAddress.getText(),txtCustomerEmail.getText(),txtCustomerPostal.getText());

        try {
            String result = customerController.updateCustomer(customerDto);
            new Alert(Alert.AlertType.INFORMATION,result).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearForm();
        loadAllCustomers();
    }

    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtCustomerId.getText());

        try {
            String result = customerController.deleteCustomer(id);
            new Alert(Alert.AlertType.INFORMATION).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearForm();
        loadAllCustomers();
    }

    public void tblCustomerOnMouseClicked(MouseEvent mouseEvent) {
        TablePosition tablePosition=tblCustomer.getSelectionModel().getSelectedCells().get(0);
        int row = tablePosition.getRow();
        CustomerDto customerDto = tblCustomer.getItems().get(row);
        TableColumn tableColumn=tablePosition.getTableColumn();
        Object id = tableColumn.getCellObservableValue(customerDto).getValue();

            int Id = Integer.parseInt(txtCustomerId.getText());
        try {
            customerDto = customerController.getCustomer(Id);
            if(customerDto != null){
                txtCustomerId.setText(Integer.toString(customerDto.getId()));
                txtCustomerName.setText(customerDto.getName());
                txtCustomerName.setText(customerDto.getAddress());
                txtCustomerEmail.setText(customerDto.getEmail());
                txtCustomerPostal.setText(customerDto.getPostalCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clearForm(){
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtCustomerEmail.setText("");
        txtCustomerPostal.setText("");
    }

    public void loadAllCustomers(){
        ObservableList<CustomerDto> customerList = tblCustomer.getItems();

        try {

            List<CustomerDto> customerDtos = customerController.getAllCustomer();
            if(customerDtos != null){
            for(CustomerDto customerDto : customerDtos) {
                customerList.add(customerDto);
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
