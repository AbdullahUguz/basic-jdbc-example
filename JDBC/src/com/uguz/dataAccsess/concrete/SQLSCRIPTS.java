package com.uguz.dataAccsess.concrete;

public class SQLSCRIPTS {
    public interface INSERT {
        String USERS = "INSERT INTO USERS (USERNAME_,NAME_SURNAME,TelNbr1,TelNbr2)  VALUES (?,?,?,?)";
    }

    public interface UPDATE {
        String USERS = "UPDATE USERS SET NAME_SURNAME=?  WHERE USERNAME_=?";
    }

    public interface SELECT {
        String USERS = "SELECT * FROM USERS";
    }

    public interface DELETE {
        String USERS = "DELETE FROM USERS WHERE ID=10";
    }

    public interface COUNT {
        String USERS = "SELECT COUNT(*) AS total FROM USERS";
    }
    public interface IN {
        String USERS = "SELECT * FROM USERS WHERE ID IN(?,?,?)";
    }
}
