package lk.ijse.dep11.entity;


import jdk.jfr.DataAmount;

public class CustomerEntity {
    private int id;
    private String name;
    private String address;
    private String email;
    private String postal;
    public CustomerEntity() {
    }

    public CustomerEntity(int id, String name, String address, String email, String postal) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.postal = postal;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", postal='" + postal + '\'' +
                '}';
    }
}
