package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UpdateWindow {

    public static void display(Item itemToUpdate) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Update Item");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label codeLabel = new Label("Code:");
        GridPane.setConstraints(codeLabel, 0, 0);
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 1);
        Label priceLabel = new Label("Price:");
        GridPane.setConstraints(priceLabel, 0, 2);
        Label stockLabel = new Label("Stock:");
        GridPane.setConstraints(stockLabel, 0, 3);

        TextField codeInput = new TextField(itemToUpdate.getCode());
        codeInput.setEditable(false);
        GridPane.setConstraints(codeInput, 1, 0);
        TextField nameInput = new TextField(itemToUpdate.getName());
        GridPane.setConstraints(nameInput, 1, 1);
        TextField priceInput = new TextField(String.valueOf(itemToUpdate.getPrice()));
        GridPane.setConstraints(priceInput, 1, 2);
        TextField stockInput = new TextField(String.valueOf(itemToUpdate.getStock()));
        GridPane.setConstraints(stockInput, 1, 3);

        Button updateButton = new Button("Update Item");
        GridPane.setConstraints(updateButton, 1, 4);
        updateButton.setOnAction(e -> {
            String newName = nameInput.getText();
            double newPrice = Double.parseDouble(priceInput.getText());
            int newStock = Integer.parseInt(stockInput.getText());
            itemToUpdate.setName(newName);
            itemToUpdate.setPrice(newPrice);
            itemToUpdate.setStock(newStock);
            Item.updateItem(itemToUpdate);
            window.close();
        });

        grid.getChildren().addAll(codeLabel, codeInput, nameLabel, nameInput, priceLabel, priceInput, stockLabel, stockInput, updateButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.showAndWait();
    }
}
