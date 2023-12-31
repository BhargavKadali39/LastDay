package com.nkxgen.spring.orm.service;

import java.util.List;

import com.nkxgen.spring.orm.model.ResTaskFilter;
import com.nkxgen.spring.orm.model.TFilterCriteria;
import com.nkxgen.spring.orm.model.Task;
import com.nkxgen.spring.orm.model.TaskDto;

public interface TaskService {

	List<TaskDto> filterTasks(ResTaskFilter resTaskFilter);

	List<TaskDto> getTasksByUserId(int userId);

	List<TaskDto> PtfilterTasks(TFilterCriteria filterCriteria);

	List<TaskDto> getAllTasks();

	Task getTaskById(int taskId);

	void saveTask(Task task);

	Boolean updateStatus(int taskId);

	// Other task-related methods...
	List<Task> getTasksByProjectId(Integer projId);

	List<Task> getCompTasksByProjectId(Integer projId);

	double getHoursWorkedByUserId(int userId);

	public double calculatePerformanceScore(int compTasks, int totalTasks);

	int getTotalTasksByUserId(int userId);

	int getCompletedTasksByUserId(int userId);
}