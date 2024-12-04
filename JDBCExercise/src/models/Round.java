package models;

public class Round {
	private Integer id;
	private Integer round;
	private Match match;
	private Integer enm_round_id;
	
	public Round(Integer id, Integer round, Match match, Integer enm_round_id) {
		this.id = id;
		this.round = round;
		this.match = match;
		this.enm_round_id = enm_round_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Integer getEnm_round_id() {
		return enm_round_id;
	}

	public void setEnm_round_id(Integer enm_round_id) {
		this.enm_round_id = enm_round_id;
	}

}
