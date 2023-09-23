package lk.ijse.dep11.dto;

public class OrderDetailDto {
    private int id;
    private int itemId;
    private int qty;
    private double unitPrice;
    private String name;

    public OrderDetailDto() {
    }

    public OrderDetailDto(int id, int itemId, int qty, double unitPrice, String name) {
        this.id = id;
        this.itemId = itemId;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", name='" + name + '\'' +
                '}';
    }
}
