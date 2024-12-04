package models;

public class PlaylistHistory {
	private User user;
	private Playlist playlist;
	
	public PlaylistHistory(User user, Playlist playlist) {
		this.user = user;
		this.playlist = playlist;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
}
