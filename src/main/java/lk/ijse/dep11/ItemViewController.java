package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.dep11.controller.CustomerController;
import lk.ijse.dep11.controller.ItemController;
import lk.ijse.dep11.dto.CustomerDto;
import lk.ijse.dep11.dto.ItemDto;

import java.util.List;

public class ItemViewController {
    public TextField txtItemId;
    public TextField txtItemName;
    public TextField txtQOH;
    public TextField txtUnitPrice;
    public Button btnAddItem;
    public Button btnUpdateItem;
    public Button btnDeleteItem;
    public TableView<ItemDto> tblItem;

    private ItemController itemController;
    public void initialize(){
        itemController = new ItemController();

        tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qoh"));
        tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));


        tblItem.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tblItem.getSelectionModel().setCellSelectionEnabled(true);
    }

    public void btnAddItemOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtItemId.getText());
        int qoh = Integer.parseInt(txtQOH.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        ItemDto itemDto = new ItemDto(id,txtItemName.getText(),qoh,unitPrice);
        try {
            String result = itemController.addItem(itemDto);
            new Alert(Alert.AlertType.INFORMATION,result).show();
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearForm();
        loadAllCustomers();
    }

    public void btnUpdateItemOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtItemId.getText());
        int qoh = Integer.parseInt(txtQOH.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        ItemDto itemDto = new ItemDto(id,txtItemName.getText(),qoh,unitPrice);
        try {
            String result = itemController.updateItem(itemDto);
            new Alert(Alert.AlertType.INFORMATION,result).show();
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearForm();
        loadAllCustomers();
    }

    public void btnDeleteItemOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtItemId.getText());

        try {
            String result = itemController.deleteItem(id);
            new Alert(Alert.AlertType.INFORMATION).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearForm();
        loadAllCustomers();
    }

    public void tblItemOnMouseClicked(MouseEvent mouseEvent) {
        TablePosition tablePosition=tblItem.getSelectionModel().getSelectedCells().get(0);
        int row = tablePosition.getRow();
        ItemDto itemDto = tblItem.getItems().get(row);
        TableColumn tableColumn=tablePosition.getTableColumn();
        Object id = tableColumn.getCellObservableValue(itemDto).getValue();

        int Id = Integer.parseInt(txtItemId.getText());
        try {
            itemDto = itemController.getItem(Id);
            if(itemDto != null){
                txtItemId.setText(Integer.toString(itemDto.getId()));
                txtItemName.setText(itemDto.getName());
                txtItemName.setText(Integer.toString(itemDto.getQtyOnHand()));
                txtUnitPrice.setText(Double.toString(itemDto.getUnitPrice()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearForm(){
        txtItemId.setText("");
        txtItemName.setText("");
        txtQOH.setText("");
        txtUnitPrice.setText("");

    }

    public void loadAllCustomers(){
        ObservableList<ItemDto> itemList = tblItem.getItems();

        try {

            List<ItemDto> itemDtos = itemController.getAllItem();
            if(itemDtos != null){
                for(ItemDto itemDto : itemDtos) {
                    itemList.add(itemDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
