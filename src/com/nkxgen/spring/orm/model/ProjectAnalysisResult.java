package com.nkxgen.spring.orm.model;

public class ProjectAnalysisResult {
    private Long projectId;
    private String projectName;
    private Double totalWorkingHours;

    public ProjectAnalysisResult(Long projectId, String projectName, Double totalWorkingHours) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.totalWorkingHours = totalWorkingHours;
    }

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Double getTotalWorkingHours() {
		return totalWorkingHours;
	}

	public void setTotalWorkingHours(Double totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}

}

