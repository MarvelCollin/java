package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        DatabaseConnection.connect();

        insertDummyData();

        LandingPage.showMenu(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
        
        // database name -> javafxcrud
        // table name -> items
        // table contain -> code, name, price, stock
    }

    private void insertDummyData() {
//        insertData("ABC123", "Item1", 10.99, 100);
//        insertData("DEF456", "Item2", 20.50, 50);
    }

    public void insertData(String code, String name, double price, int stock) {
        // Connect to the database
        Connection connection = DatabaseConnection.connect();
        if (connection != null) {
            try {
                String sql = "INSERT INTO items (code, name, price, stock) VALUES (?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, code);
                preparedStatement.setString(2, name);
                preparedStatement.setDouble(3, price);
                preparedStatement.setInt(4, stock);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("Failed to insert data.");
                }

                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DatabaseConnection.close(connection);
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}
