package com.projek.model.Request;

public class NewInventoryDb {

   private String name;
    private Integer price;
    private String merk;
    private NewRoomId roomId;

    private NewDetail detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public NewRoomId getRoomId() {
        return roomId;
    }

    public void setRoomId(NewRoomId roomId) {
        this.roomId = roomId;
    }

    public NewDetail getDetail() {
        return detail;
    }

    public void setDetail(NewDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "NewInventoryDb{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", merk='" + merk + '\'' +
                ", roomId=" + roomId +
                ", detail=" + detail +
                '}';
    }
}
