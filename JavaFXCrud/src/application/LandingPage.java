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

            // Create buttons
            Button insertButton = new Button("Insert");
            Button viewButton = new Button("View");
            Button updateButton = new Button("Update");
            Button deleteButton = new Button("Delete");

            // Add buttons to VBox
            VBox buttonBox = new VBox(10);
            buttonBox.setPadding(new Insets(20, 20, 20, 20));
            buttonBox.getChildren().addAll(insertButton, viewButton, updateButton, deleteButton);

            // Set action for insert button
            insertButton.setOnAction(e -> InsertWindow.display());

            // Add VBox to center of root layout
            root.setCenter(buttonBox);

            // Create scene
            Scene scene = new Scene(root, 400, 400);

            // Set scene and show stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("JavaFX CRUD Application");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
