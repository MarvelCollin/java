package models;

import java.time.LocalDate;

public class FriendDetail {
	private User user;
	private User friend;
//	private String friendId;
	private Integer friendStatus;
	private LocalDate followedAt;
	
	public FriendDetail(User user, User friend, Integer friendStatus, LocalDate followedAt) {
		this.user = user;
		this.friend = friend;
		this.friendStatus = friendStatus;
		this.followedAt = followedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

	public Integer getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(Integer friendStatus) {
		this.friendStatus = friendStatus;
	}

	public LocalDate getFollowedAt() {
		return followedAt;
	}

	public void setFollowedAt(LocalDate followedAt) {
		this.followedAt = followedAt;
	}
	
}
