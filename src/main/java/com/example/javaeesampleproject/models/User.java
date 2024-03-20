package com.example.javaeesampleproject.models;

public class User {
    protected int id;
    protected String username;
    protected String password;
    protected String email;

    protected String country;

    public User(){

    }

    public User(String username, String password,  String email, String country){
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
    }

    public User(String username,  String email, String country){
        super();
        this.username = username;
        this.email = email;
        this.country = country;
    }

    public User(int id, String username, String password,  String email, String country){
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
    }

    public void setId( int id ){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername( String username ) {
        this.username = username;
    }

    public void setPassword( String password ){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail( String email ){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setCountry( String country ){ this.country = country;}

    public String getCountry(){ return country; }

}
