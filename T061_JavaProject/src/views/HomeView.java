package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class HomeView {
    private Stage stage;
    private MediaPlayer mediaPlayer;

    public HomeView(Stage stage) {
        this.stage = stage;
    }

    public void showHomePage() {
        stage.setTitle("Home Page");

        VBox mainLayout = new VBox();
        mainLayout.setSpacing(10);

        HBox topContent = new HBox();
        topContent.setSpacing(10);

        VBox sidebar = createSidebar();
        VBox mainContent = createMainContent();

        topContent.getChildren().addAll(sidebar, mainContent);
        HBox.setHgrow(mainContent, Priority.ALWAYS);

        HBox bottomPlayer = createBottomPlayer();

        mainLayout.getChildren().addAll(topContent, bottomPlayer);
        VBox.setVgrow(topContent, Priority.ALWAYS);

        Scene scene = new Scene(mainLayout, 1200, 800);
        stage.setScene(scene);
        stage.show();
    }

    private VBox createSidebar() {
        VBox sidebar = new VBox(10);
        sidebar.setPadding(new Insets(10));
        sidebar.setStyle("-fx-background-color: #222;");

        Button updateProfile = new Button("Update Profile");
        Button searchButton = new Button("Search");
        Label yourLibraryLabel = new Label("Your Library");
        yourLibraryLabel.setTextFill(Color.WHITE);
        yourLibraryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        ListView<String> playlistListView = new ListView<>();
        playlistListView.getItems().addAll("Random", "My Playlist", "My Fav", "???", "Best", "hello world");
        
        updateProfile.setOnAction(e -> {
        	new ProfileUpdateView(stage).showProfileUpdate();
        });
        
        sidebar.getChildren().addAll(updateProfile, searchButton, yourLibraryLabel, playlistListView);
        return sidebar;
    }

    private VBox createMainContent() {
        VBox mainContent = new VBox(20);
        mainContent.setPadding(new Insets(10));
        mainContent.setStyle("-fx-background-color: #333;");

        HBox topBar = createTopBar();
        VBox playlistSection = createPlaylistSection();
        VBox popularArtistsSection = createPopularArtistsSection();
        VBox popularArtistsSection2 = createPopularArtistsSection();
        VBox popularArtistsSection3 = createPopularArtistsSection();
        VBox popularArtistsSection4 = createPopularArtistsSection();
        VBox popularArtistsSection5 = createPopularArtistsSection();

        mainContent.getChildren().addAll(topBar, playlistSection, popularArtistsSection,
                popularArtistsSection2, popularArtistsSection3,
                popularArtistsSection4, popularArtistsSection5);

        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        return new VBox(scrollPane);
    }

    private HBox createTopBar() {
        HBox topBar = new HBox(20);
        topBar.setAlignment(Pos.CENTER_LEFT);

        Button backButton = new Button("<");
        Button forwardButton = new Button(">");
        Button allButton = new Button("All");
        
        topBar.getChildren().addAll(backButton, forwardButton, allButton);
        return topBar;
    }

    private VBox createPlaylistSection() {
        VBox playlistSection = new VBox(10);
        Label sectionTitle = new Label("Made For Kolin");
        sectionTitle.setTextFill(Color.WHITE);
        sectionTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        HBox playlists = new HBox(10);
        playlists.setAlignment(Pos.CENTER_LEFT);

        playlists.getChildren().addAll(
                createPlaylistCard("Classic"),
                createPlaylistCard("Japon"),
                createPlaylistCard("Favorite"),
                createPlaylistCard("Mood Booster"),
                createPlaylistCard("Sleep")
        );

        playlistSection.getChildren().addAll(sectionTitle, playlists);
        return playlistSection;
    }

    private VBox createPlaylistCard(String title) {
        VBox card = new VBox(5);
        card.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(new Image(new File("assets/image/image_1.jpg").toURI().toString()));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Label titleLabel = new Label(title);
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        card.getChildren().addAll(imageView, titleLabel);
        return card;
    }

    private VBox createPopularArtistsSection() {
        VBox popularArtistsSection = new VBox(10);
        Label sectionTitle = new Label("Popular Artist");
        sectionTitle.setTextFill(Color.WHITE);
        sectionTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        HBox artists = new HBox(10);
        artists.setAlignment(Pos.CENTER_LEFT);

        artists.getChildren().addAll(
                createArtistCard("Tontontontony"),
                createArtistCard("Kolin"),
                createArtistCard("Octarzz"),
                createArtistCard("Hellzip"),
                createArtistCard("Mamang Gayatri"),
                createArtistCard("TercoretCeline"),
                createArtistCard("GlenzzAvlTree")
        );

        popularArtistsSection.getChildren().addAll(sectionTitle, artists);
        return popularArtistsSection;
    }

    private VBox createArtistCard(String name) {
        VBox card = new VBox(5);
        card.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(new Image(new File("assets/image/image_1.jpg").toURI().toString()));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Label nameLabel = new Label(name);
        nameLabel.setTextFill(Color.WHITE);
        nameLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        card.getChildren().addAll(imageView, nameLabel);
        return card;
    }

    private HBox createBottomPlayer() {
        HBox bottomPlayer = new HBox(10);
        bottomPlayer.setPadding(new Insets(10));
        bottomPlayer.setStyle("-fx-background-color: #000000;");
        bottomPlayer.setAlignment(Pos.CENTER);
        bottomPlayer.setMinHeight(70);

        // Song Info
        ImageView songImageView = new ImageView(new Image(new File("assets/image/image_1.jpg").toURI().toString()));
        songImageView.setFitWidth(50);
        songImageView.setFitHeight(50);
        Label songInfo = new Label("There is no played song\nNo artist");
        songInfo.setTextFill(Color.WHITE);

        HBox songInfoBox = new HBox(10);
        songInfoBox.getChildren().addAll(songImageView, songInfo);
        songInfoBox.setAlignment(Pos.CENTER_LEFT);

        Button shuffleButton = new Button("Shuffle");
        Button previousButton = new Button("Previous");
        Button playButton = new Button("Play");
        Button nextButton = new Button("Next");
        Button repeatButton = new Button("Repeat");

        playButton.setOnAction(e -> handlePlayPause());

        HBox playbackControls = new HBox(10);
        playbackControls.setAlignment(Pos.CENTER);
        playbackControls.getChildren().addAll(shuffleButton, previousButton, playButton, nextButton, repeatButton);

        ImageView volumeIcon = new ImageView(new Image(new File("assets/image/image_1.jpg").toURI().toString())); 
        volumeIcon.setFitWidth(20);
        volumeIcon.setFitHeight(20);
        Slider volumeSlider = new Slider(0, 100, 50); 

        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(newValue.doubleValue() / 100);
            }
        });

        HBox volumeControl = new HBox(10);
        volumeControl.setAlignment(Pos.CENTER_RIGHT);
        volumeControl.getChildren().addAll(volumeIcon, volumeSlider);

        HBox.setHgrow(songInfoBox, Priority.ALWAYS);
        HBox.setHgrow(playbackControls, Priority.ALWAYS);
        HBox.setHgrow(volumeControl, Priority.ALWAYS);

        bottomPlayer.getChildren().addAll(songInfoBox, playbackControls, volumeControl);
        return bottomPlayer;
    }

    private void handlePlayPause() {
        if (mediaPlayer == null) {
            String songPath = new File("assets/song/song_1.mp3").toURI().toString();
            Media media = new Media(songPath);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        } else {
            MediaPlayer.Status status = mediaPlayer.getStatus();
            if (status == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.play();
            }
        }
    }
}
