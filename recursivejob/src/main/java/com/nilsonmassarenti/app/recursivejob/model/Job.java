package com.nilsonmassarenti.app.recursivejob.model;

public class Job {
	private Integer id;
	private Integer jobTime;
	private int[] childJobIDs;
	
	public Job(Integer id, Integer jobTime, int[] childJobIDs2) {
		this.id = id;
		this.jobTime = jobTime;
		this.childJobIDs = childJobIDs2;
	}

	public Integer getId() {
		return id;
	}

	public Integer getJobTime() {
		return jobTime;
	}

	public int[] getChildJobIDs() {
		return childJobIDs;
	}
	


}