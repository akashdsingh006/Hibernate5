package com.entity.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="army_table")
public class Army extends Person{

	@Column(name="army_post")
	private String armyPost;
	
	@Column(name="army_battalion")
	private String armyBattalion;

	public String getArmyPost() {
		return armyPost;
	}

	public void setArmyPost(String armyPost) {
		this.armyPost = armyPost;
	}

	public String getArmyBattalion() {
		return armyBattalion;
	}

	public void setArmyBattalion(String armyBattalion) {
		this.armyBattalion = armyBattalion;
	}

	@Override
	public String toString() {
		return "Army [armyPost=" + armyPost + ", armyBattalion=" + armyBattalion + "]"+super.toString();
	}
	
	
}
