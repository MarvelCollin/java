package views;

import controllers.UserController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class RegisterView {
    private final UserController userController;

    public RegisterView(UserController userController) {
        this.userController = userController;
    }

    public void showRegistration(Stage primaryStage) {
        primaryStage.setTitle("Register");

        VBox vbox = createRegistrationForm(primaryStage);

        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createRegistrationForm(Stage primaryStage) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(25));
        vbox.setStyle("-fx-background-color: #000000;");

        Label titleLabel = new Label("Sign up to start listening");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.WHITE);

        Label usernameLabel = new Label("Username");
        usernameLabel.setTextFill(Color.WHITE);
        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Username");

        Label emailLabel = new Label("Email address");
        emailLabel.setTextFill(Color.WHITE);
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("name@domain.com");

        Label passwordLabel = new Label("Password");
        passwordLabel.setTextFill(Color.WHITE);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button registerButton = new Button("Next");
        registerButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
        registerButton.setOnAction(event -> {
            String username = usernameTextField.getText();
            String email = emailTextField.getText();
            String password = passwordField.getText();
            userController.insertUser(username, password, email);
            LoginView loginView = new LoginView(userController);
            loginView.showLogin(primaryStage);
        });

        Label loginLabel = new Label("Already have an account? Log in here");
        loginLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        loginLabel.setTextFill(Color.LIGHTGRAY);
        loginLabel.setOnMouseClicked(event -> {
            LoginView loginView = new LoginView(userController);
            loginView.showLogin(primaryStage);
        });

        vbox.getChildren().addAll(titleLabel, usernameLabel, usernameTextField, emailLabel, emailTextField, passwordLabel, passwordField, registerButton, loginLabel);
        return vbox;
    }
}
