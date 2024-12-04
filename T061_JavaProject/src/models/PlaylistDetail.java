package models;

import java.time.LocalDate;

public class PlaylistDetail {
	private Playlist playlist;
	private Song song;
//	private String playlistId;
//	private String songId;
	private LocalDate createdAt;
	
	public PlaylistDetail(Playlist playlist, Song song, LocalDate createdAt) {
		this.playlist = playlist;
		this.song = song;
		this.createdAt = createdAt;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
