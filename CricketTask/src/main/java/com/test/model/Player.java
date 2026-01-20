package com.test.model;

public class Player {
	private int id;
	private String name;
	private String role;
	private int runs;
	private int matches;
	private int balls;
	private int wickets;
	private int runsConceded;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getRunsConceded() {
		return runsConceded;
	}

	public void setRunsConceded(int runsConceded) {
		this.runsConceded = runsConceded;
	}

	public double getBattingAverage() {
		return (double) runs / Math.max(1, matches);
	}

	public double getBowlingAverage() {
		return (double) runsConceded / Math.max(1, wickets);
	}

}
