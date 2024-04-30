package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item {

    private String code;
    private String name;
    private double price;
    private int stock;

    public Item(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() {
		return code;
	}
    
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public static Item insertItem(String name, double price, int stock) {
        String code = generateRandomCode();

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
                    return new Item(code, name, price, stock);
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
        return null;
    }

    public static List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        Connection connection = DatabaseConnection.connect();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM items";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String code = resultSet.getString("code");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    int stock = resultSet.getInt("stock");

                    itemList.add(new Item(code, name, price, stock));
                }

                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DatabaseConnection.close(connection);
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
        return itemList;
    }

    public static void updateItem(String code, String name, double price, int stock) {
        Connection connection = DatabaseConnection.connect();
        if (connection != null) {
            try {
                String sql = "UPDATE items SET name = ?, price = ?, stock = ? WHERE code = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, price);
                preparedStatement.setInt(3, stock);
                preparedStatement.setString(4, code);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Item updated successfully.");
                } else {
                    System.out.println("Failed to update item.");
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
    
    public static void deleteItem(String code) {
        Connection connection = DatabaseConnection.connect();
        if (connection != null) {
            try {
                String sql = "DELETE FROM items WHERE code = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, code);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Item deleted successfully.");
                } else {
                    System.out.println("Failed to delete item.");
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


    private static String generateRandomCode() {
        Random rand = new Random();
        StringBuilder codeBuilder = new StringBuilder("PD-");
        for (int i = 0; i < 3; i++) {
            codeBuilder.append(rand.nextInt(10)); 
        }
        return codeBuilder.toString();
    }
}
