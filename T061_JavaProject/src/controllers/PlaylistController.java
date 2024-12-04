package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Song;

public class PlaylistController {

	public PlaylistController() {
		// TODO Auto-generated constructor stub
	}
	
	public ObservableList<Song> getSongs() {
        ObservableList<Song> songs = FXCollections.observableArrayList(
            new Song("1", null, "Chill", "Song 3", "file:song3.jpg", "file:song3.mp3", 180),
            new Song("2", null, "Chill", "Song 5", "file:song5.jpg", "file:song5.mp3", 200),
            new Song("3", null, "Chill", "Song 6", "file:song6.jpg", "file:song6.mp3", 210),
            new Song("4", null, "Chill", "Song 9", "file:song9.jpg", "file:song9.mp3", 230),
            new Song("5", null, "Chill", "Song 10", "file:song10.jpg", "file:song10.mp3", 240),
            new Song("6", null, "Chill", "Song 14", "file:song14.jpg", "file:song14.mp3", 250),
            new Song("7", null, "Chill", "Song 17", "file:song17.jpg", "file:song17.mp3", 260),
            new Song("8", null, "Chill", "Song 18", "file:song18.jpg", "file:song18.mp3", 270)
        );
        return songs;
    }

}
