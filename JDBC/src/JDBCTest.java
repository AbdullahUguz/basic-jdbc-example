import com.uguz.dataAccsess.abstracts.CRUDOperations;
import com.uguz.dataAccsess.concrete.CRUDOperationMsSQL;
import com.uguz.entity.User;

import java.sql.*;


public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        User user1 =new User();
        user1.setUserName("AYŞE");
        user1.setNameAndSurname("AYŞE kasa");
        user1.setTelNbr1(1231231212);
        user1.setTelNbr2(1231231213);

        CRUDOperations crud=new CRUDOperationMsSQL();
        // crud.createOperation(user1);
        // crud.readOperation();
        // crud.updateOperation(user1);
        // crud.deleteOperation();

        CRUDOperationMsSQL sql=new CRUDOperationMsSQL();
      //  sql.countUsers();
        sql.multiElemanOperation();

    }
}
