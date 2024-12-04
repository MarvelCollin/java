package views;

import controllers.UserController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ForgetPasswordView {
    private final UserController userController;
    private Stage stage; 

    public ForgetPasswordView(UserController userController, Stage stage) {
        this.userController = userController;
        this.stage = stage; 
    }

    public void showForgetPassword(Stage primaryStage) {
        this.stage = primaryStage;
        stage.setTitle("Forgot Password");

        VBox vbox = createForgetPasswordForm();

        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);

        stage.show();
    }

    private VBox createForgetPasswordForm() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(25));
        vbox.setStyle("-fx-background-color: #000000;");
        
        Hyperlink aLogin = new Hyperlink("Go Back");

        Label titleLabel = new Label("Forgot Password");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.WHITE);

        Label emailLabel = new Label("Enter your Email");
        emailLabel.setTextFill(Color.WHITE);
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("name@domain.com");

        Label passwordLabel = new Label("Enter your New Password");
        passwordLabel.setTextFill(Color.WHITE);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("New Password");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
        submitButton.setOnAction(event -> {
            String email = emailTextField.getText();
            String password = passwordField.getText();
            userController.changePassword(email, password);
            stage.close();
            new LoginView(userController).showLogin(stage);
        });
        
        aLogin.setOnAction(e -> {
        	new LoginView(userController).showLogin(stage);
        });

        vbox.getChildren().addAll(titleLabel, emailLabel, emailTextField, passwordLabel, passwordField, submitButton, aLogin);
        return vbox;
    }
}
