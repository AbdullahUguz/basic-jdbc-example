package com.uguz.dataAccsess.abstracts;

import com.uguz.entity.User;

import java.sql.SQLException;

public interface CRUDOperations {
  void connectionDatabase() throws SQLException;
  void createOperation(User user) throws SQLException;
  void readOperation() throws SQLException;
  void updateOperation(User user);
  void deleteOperation();
}
