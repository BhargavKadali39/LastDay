package com.nkxgen.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nkxgen.spring.orm.dao.AnalyticsDao;
import com.nkxgen.spring.orm.model.AnalyticsDto;
import com.nkxgen.spring.orm.model.ModuleSummary;
import com.nkxgen.spring.orm.model.Past30CompletionSummary;
import com.nkxgen.spring.orm.model.ProjectSummary;
import com.nkxgen.spring.orm.model.SubtaskSummary;
import com.nkxgen.spring.orm.model.TaskSummary;

public class AnalyticService {

	@Autowired
	private AnalyticsDao analyticsDao;

	// Constructor

	public AnalyticsDto getSummariesByUserId(int userId) {
		AnalyticsDto summaryOutput = new AnalyticsDto();

		List<ProjectSummary> projectSummaries = analyticsDao.getProjectSummariesByUserId(userId);
		List<ModuleSummary> moduleSummaries = analyticsDao.getModuleSummariesByUserId(userId);
		List<TaskSummary> taskSummaries = analyticsDao.getTaskSummariesByUserId(userId);
		List<SubtaskSummary> subtaskSummaries = analyticsDao.getSubtaskSummariesByUserId(userId);
		List<Past30CompletionSummary> past30CompletionSummaries = analyticsDao.getPast30CompletionSummaries();
		summaryOutput.setProjectSummaries(projectSummaries);
		summaryOutput.setModuleSummaries(moduleSummaries);
		summaryOutput.setTaskSummaries(taskSummaries);
		summaryOutput.setSubtaskSummaries(subtaskSummaries);

		return summaryOutput;
	}

	public List<Past30CompletionSummary> getPast30CompletionSummary() {
		return analyticsDao.getPast30CompletionSummaries();
	}
}
