package models;

public class LastPlayedSong {
//	private String songId;
//	private String userId;
	private Song song;
	private User user;
	
	public LastPlayedSong(Song song, User user) {
		this.song = song;
		this.user = user;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
