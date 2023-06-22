package com.nkxgen.spring.orm.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkxgen.spring.orm.dao.ProjectDAO;
import com.nkxgen.spring.orm.model.Project;
import com.nkxgen.spring.orm.model.ProjectDto;
import com.nkxgen.spring.orm.model.ProjectFilter;
import com.nkxgen.spring.orm.model.ProjectInput;
import com.nkxgen.spring.orm.model.ProjectTask;
import com.nkxgen.spring.orm.model.Task;

@Service
public class ProjectService {
	private final ProjectTaskService projectTaskService;
	private final TaskService taskService;
	
	private final ProjectDAO projectDAO;

	@Autowired
	public ProjectService(ProjectDAO projectDAO,ProjectTaskService projectTaskService,TaskService taskService) {
		this.taskService = taskService;
		this.projectTaskService = projectTaskService;
		this.projectDAO = projectDAO;
	}

	public List<ProjectDto> getAllProjects() {
		List<ProjectDto> allProjs = projectDAO.getAllProjects();

		return allProjs;
	}

	public ProjectDto getProjectStatById(ProjectDto projectDto) {
		projectDAO.getProjectTotalSprints(projectDto);
		projectDAO.getProjectExpiredSprints(projectDto);
		return projectDto;
		
	}

	// public void testProj() {
	// try {
	// System.out.println("got all projs " + allProjs);
	// for (ProjectDto projectDto : allProjs) {
	// int projId = projectDto.getProjectId();
	// System.out.println("getting data for " + projId);
	// List<Integer> projectStats = getProjectStatsById(projId);
	// System.out.println("data got" + projectStats);
	// projectDto.setSprint_data(projectStats);
	// System.out.println("added sprintData");
	// }
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public List<ProjectDto> filterProjects(ProjectFilter projectFilter) {
		// TODO Auto-generated method stub
		return projectDAO.getFilterProjects(projectFilter);
	}

	public ProjectDto getProjectById(Integer projId) {
		return projectDAO.getProjectById(projId);
	}

	// public Integer getProjectTasksById(Integer projId) {
	// return projectDAO.getProjectTasksById(projId);
	// }

	// public Integer getAllProjectSprintsById(Integer projId) {
	// return projectDAO.getAllProjectSprintsById(projId);
	// }

	public List<Integer> getProjectStatsById(Integer projId) {

		System.out.println("in for data" + projId);
		List<Integer> sprintData = new ArrayList<>();

		Integer total_sprints = projectDAO.getAllSprintsByProjectId(projId);
		sprintData.add(total_sprints);
		Integer completed_sprints = projectDAO.getCompletedSprintsByProjectId(projId);
		sprintData.add(completed_sprints);
		Integer running_sprints = total_sprints - completed_sprints;
		sprintData.add(running_sprints);
		System.out.println("total_sprints " + total_sprints + " completed_sprints " + completed_sprints
				+ " running_sprints " + running_sprints);
		return sprintData;
	}

	// public Integer getResourcePerformanceById(Integer projId) {
	// return projectDAO.getAllProjectSprintsById(projId);
	// }

	public void setNewProject(ProjectInput projectInput) {
		Date date = new Date(System.currentTimeMillis());
		// Date sqlDate = new Date(System.currentTimeMillis());
		projectInput.setProjectStartDate(date);
		projectInput.setProjectStatus("O");
		Project project = projectInput.toEntity();
		projectDAO.setNewProject(project);
	}
	// Add methods for creating, updating, and deleting projects if needed

	public void setTasksToProjDto(int projectId,ProjectDto projectDto) {
		
		List<Task> tasks = taskService.getTasksByProjectId(projectId);
		List<Task> compTasks = taskService.getCompTasksByProjectId(projectId);
		
		List<ProjectTask> projectTasks = projectTaskService.getTasksByProjectId(projectId);
		List<ProjectTask> compProjectTasks = projectTaskService.getCompTasksByProjectId(projectId);
		
		projectDto.setTotalTasks(tasks.size());
		projectDto.setCompletedTasks(compTasks.size());

		projectDto.setTotalIndvTasks(projectTasks.size());
		projectDto.setCompletedIndvTasks(compProjectTasks.size());
	}
}