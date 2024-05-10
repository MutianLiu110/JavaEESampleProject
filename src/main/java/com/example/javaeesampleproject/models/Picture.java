package com.example.javaeesampleproject.models;

public class Picture {
    int id;
    String pic;

    public Picture(){

    }

    public Picture(String pic){
        super();
        this.pic = pic;
    }

    public Picture(int id, String pic){
        super();
        this.id = id;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
