package com.example.javaeesampleproject.models;

public class HotelPicRel {
    int id;
    int hotel_id;
    int pic_id;

    public HotelPicRel(){

    }

    public HotelPicRel(int id, int hotel_id, int pic_id){
        super();
        this.id = id;
        this.hotel_id = hotel_id;
        this.pic_id = pic_id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

}
