package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LandingPage {

    public static void showMenu(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();

            Button insertButton = new Button("Insert");
            Button viewButton = new Button("View");
            Button updateButton = new Button("Update");
            Button deleteButton = new Button("Delete");

            VBox buttonBox = new VBox(10);
            buttonBox.setPadding(new Insets(20, 20, 20, 20));
            buttonBox.getChildren().addAll(insertButton, viewButton, updateButton, deleteButton);

            insertButton.setOnAction(e -> InsertWindow.display());
            viewButton.setOnAction(e -> ViewWindow.display());
            updateButton.setOnAction(e -> UpdateWindow.display());
            deleteButton.setOnAction(e -> DeleteWindow.display());

            root.setCenter(buttonBox);

            Scene scene = new Scene(root, 400, 400);

            primaryStage.setScene(scene);
            primaryStage.setTitle("JavaFX CRUD Application");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
