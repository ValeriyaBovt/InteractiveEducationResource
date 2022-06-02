package sample.ForDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DataBaseHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException
    {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort +"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
     public void registrationUser (User user)
     {
         String insert = "INSERT INTO " + Const.USER_TABLE + "(" +Const.USER_NAME +"," +Const.USER_SURNAME+","
                 +Const.USER_LOGIN + ","+Const.USER_PASSWORD + "," +Const.USER_POST + "," + Const.USER_LEVEL +")" +
                 "VALUES(?,?,?,?,?,?)";

         try {
             PreparedStatement prSt = getDbConnection().prepareStatement(insert);
             prSt.setString(1, user.getName());
             prSt.setString(2, user.getSurname());
             prSt.setString(3, user.getLogin());
             prSt.setString(4, user.getPassword());
             prSt.setString(5, user.getEmail());
             prSt.setString(6, user.getLevel());
             prSt.executeUpdate();//додати
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }

     }
     public ResultSet getUser(User user) {
         ResultSet resultSet = null;
         String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                 Const.USER_LOGIN+ "=? AND " + Const.USER_PASSWORD+ "=?";
         try {
             PreparedStatement prSt = getDbConnection().prepareStatement(select);
             prSt.setString(1, user.getLogin());
             prSt.setString(2, user.getPassword());

             resultSet = prSt.executeQuery();//взяти
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }

         return resultSet;
     }

}
