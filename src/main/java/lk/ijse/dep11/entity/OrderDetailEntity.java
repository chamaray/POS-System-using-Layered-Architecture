package lk.ijse.dep11.entity;

public class OrderDetailEntity {
    private int id;
    private int itemId;
    private int order_id;
    private int qty;
    private double unitPrice;
    private String name;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(int id, int itemId, int order_id, int qty, double unitPrice, String name) {
        this.id = id;
        this.itemId = itemId;
        this.order_id = order_id;
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

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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
        return "OrderDetailEntity{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", order_id=" + order_id +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", name='" + name + '\'' +
                '}';
    }
}
