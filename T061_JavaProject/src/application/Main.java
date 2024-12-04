package application;
import controllers.PlaylistController;
import controllers.UserController;
import javafx.application.Application;
import javafx.stage.Stage;
import views.HomeView;
import views.LoginView;
import views.PlaylistView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        UserController userController = new UserController();
        PlaylistController playlistController = new PlaylistController();
        new PlaylistView(playlistController).showPlaylist(primaryStage);
//        LoginView loginView = new LoginView(userController);
//        primaryStage.setTitle("Login"); 
//        loginView.showLogin(primaryStage); 
//    	new HomeView(primaryStage).showHomePage();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
