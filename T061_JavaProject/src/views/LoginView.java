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

public class LoginView {
    private final UserController userController;
    private Stage stage;

    public LoginView(UserController userController) {
        this.userController = userController;
    }

    public void showLogin(Stage primaryStage) {
        this.stage = primaryStage;
        stage.setTitle("Login");

        VBox vbox = createLoginForm();

        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private VBox createLoginForm() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(25));
        vbox.setStyle("-fx-background-color: #333333;");

        Label logo = new Label("MortiFy");
        logo.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        logo.setTextFill(Color.WHITE);

        Label slogan = new Label("Your best mood booster.");
        slogan.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        slogan.setTextFill(Color.WHITE);

        Label emailLabel = new Label("Email");
        emailLabel.setTextFill(Color.WHITE);
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("Email");

        Label passwordLabel = new Label("Password");
        passwordLabel.setTextFill(Color.WHITE);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Log In");
        loginButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
        loginButton.setOnAction(event -> {
            String email = emailTextField.getText();
            String password = passwordField.getText();
            boolean loggedIn = userController.login(email, password);

            if (loggedIn) {
            	new HomeView(stage).showHomePage();
            }
        });

        Label forgotPasswordLabel = new Label("Forgot your password?");
        forgotPasswordLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        forgotPasswordLabel.setTextFill(Color.LIGHTGRAY);
        forgotPasswordLabel.setOnMouseClicked(event -> {
            ForgetPasswordView forgetPasswordView = new ForgetPasswordView(userController, stage);
            forgetPasswordView.showForgetPassword(stage);
        });

        Label signUpLabel = new Label("Don't have an account? Sign up for MortiFy.");
        signUpLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        signUpLabel.setTextFill(Color.LIGHTGRAY);
        signUpLabel.setOnMouseClicked(event -> {
            RegisterView registerView = new RegisterView(userController);
            registerView.showRegistration(stage);
        });

        vbox.getChildren().addAll(logo, slogan, emailLabel, emailTextField, passwordLabel, passwordField, loginButton, forgotPasswordLabel, signUpLabel);
        return vbox;
    }
}
