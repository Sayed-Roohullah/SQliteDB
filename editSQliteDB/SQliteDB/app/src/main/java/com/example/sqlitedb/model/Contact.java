package com.example.sqlitedb.model;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private String date;

    public Contact(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public Contact(int id, String name, String phoneNumber,String date) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date =date;
    }
    public Contact() {

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() { return date;}

    public void setDate(String date){
        this.date = phoneNumber;
    }

}
