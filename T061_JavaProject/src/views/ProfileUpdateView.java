package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class ProfileUpdateView {
    private Stage stage;
    private ImageView profileImageView;

    public ProfileUpdateView(Stage stage) {
        this.stage = stage;
    }

    public void showProfileUpdate() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle("Profile details");

        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20));
        dialogVbox.setAlignment(Pos.CENTER);
        dialogVbox.setStyle("-fx-background-color: #333333;");

        Label titleLabel = new Label("Profile details");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.WHITE);

        profileImageView = new ImageView(new Image(new File("assets/image/image_1.jpg").toURI().toString()));
        profileImageView.setFitWidth(100);
        profileImageView.setFitHeight(100);
        profileImageView.setOnMouseClicked(event -> handleImageUpload());

        TextField nameField = new TextField("Kolin");

        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
        saveButton.setOnAction(event -> handleSave(nameField.getText()));

        Label infoLabel = new Label("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        infoLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 10));
        infoLabel.setTextFill(Color.LIGHTGRAY);
        infoLabel.setWrapText(true);

        HBox imageBox = new HBox(10);
        imageBox.setAlignment(Pos.CENTER);
        imageBox.getChildren().addAll(profileImageView, nameField);

        dialogVbox.getChildren().addAll(titleLabel, imageBox, saveButton, infoLabel);

        Scene dialogScene = new Scene(dialogVbox, 400, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private void handleImageUpload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            profileImageView.setImage(new Image(selectedFile.toURI().toString()));
        }
    }

    private void handleSave(String name) {
        System.out.println("Profile updated: " + name);
        stage.close();
    }
}
