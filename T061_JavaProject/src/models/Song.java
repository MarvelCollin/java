package models;

public class Song {
	private String songId;
	private User user;
//	private String userId;
	private String genre;
	private String songName;
	private String songImage;
	private String songPath;
	private Integer duration;
	
	public Song(String songId, User user, String genre, String songName, String songImage, String songPath,
			Integer duration) {
		this.songId = songId;
		this.user = user;
		this.genre = genre;
		this.songName = songName;
		this.songImage = songImage;
		this.songPath = songPath;
		this.duration = duration;
	}

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongImage() {
		return songImage;
	}

	public void setSongImage(String songImage) {
		this.songImage = songImage;
	}

	public String getSongPath() {
		return songPath;
	}

	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}
