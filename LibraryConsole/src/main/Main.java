package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: black;");

        Region box1 = createBox();
        gridPane.add(box1, 0, 0);

        Region box2 = createBox();
        gridPane.add(box2, 0, 1);

        Region box3 = createBox();
        gridPane.add(box3, 1, 0, 1, 2);

        Scene scene = new Scene(gridPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createBox() {
        Region box = new Region();
        box.setPrefSize(200, 100);
        box.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(20), null)));
        box.setStyle("-fx-border-color: white; -fx-border-width: 1; -fx-border-radius: 20;");
        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
