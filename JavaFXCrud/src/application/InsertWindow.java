package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InsertWindow {

    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Insert Item");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Labels
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        Label priceLabel = new Label("Price:");
        GridPane.setConstraints(priceLabel, 0, 1);
        Label stockLabel = new Label("Stock:");
        GridPane.setConstraints(stockLabel, 0, 2);

        // Text fields
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0);
        TextField priceInput = new TextField();
        GridPane.setConstraints(priceInput, 1, 1);
        TextField stockInput = new TextField();
        GridPane.setConstraints(stockInput, 1, 2);

        // Button
        Button addButton = new Button("Add Item");
        GridPane.setConstraints(addButton, 1, 3);
        addButton.setOnAction(e -> {
            String name = nameInput.getText();
            double price = Double.parseDouble(priceInput.getText());
            int stock = Integer.parseInt(stockInput.getText());
            Item.insertItem(name, price, stock);
            window.close();
        });

        grid.getChildren().addAll(nameLabel, nameInput, priceLabel, priceInput, stockLabel, stockInput, addButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.showAndWait();
    }

   
}
