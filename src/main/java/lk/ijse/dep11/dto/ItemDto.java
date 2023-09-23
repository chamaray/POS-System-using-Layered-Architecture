package lk.ijse.dep11.dto;

public class ItemDto {
    private int id;
    private String name;
    private int qoh;
    private double unitPrice;

    public ItemDto() {
    }

    public ItemDto(int id, String name, int qoh, double unitPrice) {
        this.id = id;
        this.name = name;
        this.qoh = qoh;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQOH() {
        return qoh;
    }

    public void setQOH(int qtyOnHand) {
        this.qoh = qoh;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qoh=" + qoh +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
