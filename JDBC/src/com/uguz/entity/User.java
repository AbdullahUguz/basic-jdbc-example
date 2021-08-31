package com.uguz.entity;

public class User {
    private String userName;
    private String nameAndSurname;
    private int telNbr1;
    private int telNbr2;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public int getTelNbr1() {
        return telNbr1;
    }

    public void setTelNbr1(int telNbr1) {
        this.telNbr1 = telNbr1;
    }

    public int getTelNbr2() {
        return telNbr2;
    }

    public void setTelNbr2(int telNbr2) {
        this.telNbr2 = telNbr2;
    }
}
