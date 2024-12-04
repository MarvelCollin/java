package models;

public class Pet {
	private Integer id;
	private String name;
	private Integer atk;
	private Integer hp;
	private Integer lv;
	private Integer exp;
	private Integer pos;
	
	public Pet(Integer id, String name, Integer atk, Integer hp, Integer lv, Integer exp, Integer pos) {
		this.id = id;
		this.name = name;
		this.atk = atk;
		this.hp = hp;
		this.lv = lv;
		this.exp = exp;
		this.pos = pos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAtk() {
		return atk;
	}

	public void setAtk(Integer atk) {
		this.atk = atk;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getLv() {
		return lv;
	}

	public void setLv(Integer lv) {
		this.lv = lv;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}
}
