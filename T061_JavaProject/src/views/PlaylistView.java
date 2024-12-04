package views;

import controllers.PlaylistController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Song;

public class PlaylistView {
    private final PlaylistController playlistController;

    public PlaylistView(PlaylistController playlistController) {
        this.playlistController = playlistController;
    }

    public void showPlaylist(Stage primaryStage) {
        primaryStage.setTitle("Chill");

        VBox vbox = createPlaylistView();

        Scene scene = new Scene(vbox, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createPlaylistView() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(25));
        vbox.setStyle("-fx-background-color: #000000;");

        ImageView playlistImage = new ImageView(new Image("file:playlist.jpg"));
        playlistImage.setFitWidth(100);
        playlistImage.setFitHeight(100);

        Text playlistTitle = new Text("Chill");
        playlistTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-fill: white;");

        VBox topSection = new VBox(playlistImage, playlistTitle);
        topSection.setSpacing(10);
        topSection.setAlignment(Pos.CENTER);

        Button playButton = new Button("", new ImageView(new Image("file:play.png")));
        playButton.setStyle("-fx-background-color: transparent;");
        
        Button shuffleButton = new Button("", new ImageView(new Image(new File("assets/image/"))));
        shuffleButton.setStyle("-fx-background-color: transparent;");

        HBox controlButtons = new HBox(playButton, shuffleButton);
        controlButtons.setSpacing(10);
        controlButtons.setPadding(new Insets(10));
        controlButtons.setAlignment(Pos.CENTER);

        ListView<Song> songListView = new ListView<>(playlistController.getSongs());
        songListView.setStyle("-fx-background-color: #000000; -fx-text-fill: white;");
        songListView.setCellFactory(param -> new SongCell());

        vbox.getChildren().addAll(topSection, controlButtons, songListView);
        VBox.setVgrow(songListView, Priority.ALWAYS);

        return vbox;
    }

    private static class SongCell extends javafx.scene.control.ListCell<Song> {
        @Override
        protected void updateItem(Song item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(item.toString());
                setStyle("-fx-text-fill: white;");
            }
        }
    }
}
