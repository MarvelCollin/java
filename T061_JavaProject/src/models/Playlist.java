package models;

import java.time.LocalDate;

public class Playlist {
	private String playlistId;
	private String playlistName;
	private User user;
	private String playlistImage;
	private LocalDate createdAt;
	
	public Playlist(String playlistId, String playlistName, User user, String playlistImage, LocalDate createdAt) {
		this.playlistId = playlistId;
		this.playlistName = playlistName;
		this.user = user;
		this.playlistImage = playlistImage;
		this.createdAt = createdAt;
	}

	public String getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(String playlistId) {
		this.playlistId = playlistId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPlaylistImage() {
		return playlistImage;
	}

	public void setPlaylistImage(String playlistImage) {
		this.playlistImage = playlistImage;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
