package com.uguz.dataAccsess.concrete;

import com.uguz.dataAccsess.abstracts.CRUDOperations;
import com.uguz.entity.User;

import java.sql.*;

public class CRUDOperationMsSQL implements CRUDOperations {
    Connection connection;
    String url = "jdbc:sqlserver://192.168.120.137;databaseName=TEST";
    String users = "SA";
    String password = ""; //Your db password

    public CRUDOperationMsSQL() throws SQLException {
        connectionDatabase();
    }

    @Override
    public void connectionDatabase() throws SQLException {
        connection = DriverManager.getConnection(url, users, password);
        System.out.println("connected");
    }

    @Override
    public void createOperation(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLSCRIPTS.INSERT.USERS)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getNameAndSurname());
            preparedStatement.setInt(3, user.getTelNbr1());
            preparedStatement.setInt(4, user.getTelNbr2());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {

                System.out.println("A new user was inserted successfully!");

            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void readOperation() {
        // String sql = "Select * from users";
        // PreparedStatement preparedStatement = connection.prepareStatement(sql)
        try (Statement statement = connection.createStatement()) {

            try (ResultSet resultSet = statement.executeQuery(SQLSCRIPTS.SELECT.USERS)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String userName = resultSet.getString(2);
                    String nameAndSurname = resultSet.getString(3);
                    int telNmbr1 = resultSet.getInt(4);
                    int telNmbr2 = resultSet.getInt(5);
                    System.out.println(id + " " + userName + " " + nameAndSurname + " " + telNmbr1 + " " + telNmbr2);
                }
            }
//            connection.close();
//            statement.close();
        } catch (SQLException e) {

            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void updateOperation(User user) {
        //    String sql = "Update USERS Set NAME_SURNAME=? WHERE USERNAME_=? ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLSCRIPTS.UPDATE.USERS);) {
            preparedStatement.setString(1, user.getNameAndSurname());
            preparedStatement.setString(2, user.getUserName());

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {

                System.out.println("An existing user was updated  successfully!");

            }


        } catch (SQLException e) {

            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void deleteOperation() {
        // String sql = "DELETE FROM USERS WHERE ID=8";

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLSCRIPTS.DELETE.USERS)) {

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {

                System.out.println("The user was deleted successfully!");
            }
        } catch (SQLException e) {

            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }

    public void countUsers() throws SQLException {
        //  String sql = "SELECT COUNT(*) AS total FROM USERS";
        // PreparedStatement preparedStatement=connection.prepareStatement(SQLSCRIPTS.COUNT.USERS)
        try (Statement statement = connection.createStatement()) {

            try (ResultSet resultSet = statement.executeQuery(SQLSCRIPTS.COUNT.USERS)) {

                if (resultSet.next() && (resultSet.getInt("total") == 0)) {
                    System.out.println("The User table is empty!");
                } else {
                    System.out.println(resultSet.getInt("total"));
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
    }
    public void multiElemanOperation(){
      //  String sql="select * from users where ID in (?,?,?)";
        try (PreparedStatement preparedStatement =connection.prepareCall(SQLSCRIPTS.IN.USERS)){
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,2);
            preparedStatement.setInt(3,3);
           try(ResultSet resultSet=preparedStatement.executeQuery()) {

               while (resultSet.next()) {
                   System.out.println(resultSet.getString(1) + " "
                           + resultSet.getString(2) + " "
                           + resultSet.getString(3) + " "
                   );
               }
           }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
