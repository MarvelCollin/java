package models;


public class User {
	private String userId;
	private String username;
	private String email;
	private String password;
	private	String dob;
	private Integer isPremium;
	private String profilePicture;
	private String headerImage;
	private String theme;
	
	public User(String userId, String username, String email, String password, String dob, Integer isPremium,
			String profilePicture, String headerImage, String theme) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.isPremium = isPremium;
		this.profilePicture = profilePicture;
		this.headerImage = headerImage;
		this.theme = theme;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(Integer isPremium) {
		this.isPremium = isPremium;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getHeaderImage() {
		return headerImage;
	}

	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
