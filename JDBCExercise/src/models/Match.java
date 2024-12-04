package models;

public class Match {
	private Integer id;
	private String team_name;
	private Integer win;
	private User user; // userid
	
	public Match(Integer id, String team_name, Integer win, User user) {
		this.id = id;
		this.team_name = team_name;
		this.win = win;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
