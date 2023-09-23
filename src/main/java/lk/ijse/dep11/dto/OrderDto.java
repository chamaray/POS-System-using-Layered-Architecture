package lk.ijse.dep11.dto;
import java.util.Date;
import java.util.List;

public class OrderDto {
    private int id;
    private int custId;
    private Date orderDate;
    private double total;

    List<OrderDetailDto> detailDtos;
    public OrderDto() {
    }

    public OrderDto(int id, int custId, Date orderDate, double total) {
        this.id = id;
        this.custId = custId;
        this.orderDate = orderDate;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", custId=" + custId +
                ", orderDate=" + orderDate +
                ", total=" + total +
                '}';
    }
}
