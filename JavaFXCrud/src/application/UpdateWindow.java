package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UpdateWindow {

    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Update Item");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        for (Item item : Item.getAllItems()) {
            GridPane itemGrid = new GridPane();
            itemGrid.setPadding(new Insets(10));
            itemGrid.setVgap(5);
            itemGrid.setHgap(10);

            Label codeLabel = new Label("Code:");
            TextField codeInput = new TextField(item.getCode());
            codeInput.setEditable(false);

            Label nameLabel = new Label("Name:");
            TextField nameInput = new TextField(item.getName());

            Label priceLabel = new Label("Price:");
            TextField priceInput = new TextField(String.valueOf(item.getPrice()));

            Label stockLabel = new Label("Stock:");
            TextField stockInput = new TextField(String.valueOf(item.getStock()));

            Button updateButton = new Button("Update");
            updateButton.setOnAction(e -> {
                String newName = nameInput.getText();
                double newPrice = Double.parseDouble(priceInput.getText());
                int newStock = Integer.parseInt(stockInput.getText());
                Item.updateItem(item.getCode(), newName, newPrice, newStock);
                System.out.println("Item updated successfully.");
            });

            itemGrid.addRow(0, codeLabel, codeInput);
            itemGrid.addRow(1, nameLabel, nameInput);
            itemGrid.addRow(2, priceLabel, priceInput);
            itemGrid.addRow(3, stockLabel, stockInput);
            itemGrid.add(updateButton, 1, 4);

            root.getChildren().add(itemGrid);
        }

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();
    }
}
