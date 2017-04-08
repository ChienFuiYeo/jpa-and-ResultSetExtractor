package com.example.base.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEMO_STATES")
public class DemoStates {

	@Id
	private String st;
	private String stateName;

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "DemoStates [st=" + st + ", stateName=" + stateName + "]";
	}

}
