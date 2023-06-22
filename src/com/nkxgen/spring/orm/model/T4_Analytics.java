package com.nkxgen.spring.orm.model;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class T4_Analytics {
	private List<String> task_name;
	private List<Integer> task_working_hours;

	private List<String> project_name;
	private List<Double> project_working_hours;

	private List<String> sub_task_name;
	private List<Integer> sub_task_working_hours;
	private List<String> module_name;
	private List<Integer> module_working_hours;
	private HashMap<Date, String> past_30_days_analytics;

	public HashMap<Date, String> getPast_30_days_analytics() {
		return past_30_days_analytics;
	}

	public void setPast_30_days_analytics(HashMap<Date, String> past_30_days_analytics) {
		this.past_30_days_analytics = past_30_days_analytics;
	}

	public List<String> getTask_name() {
		return task_name;
	}

	public void setTask_name(List<String> task_name) {
		this.task_name = task_name;
	}

	public List<Integer> getTask_working_hours() {
		return task_working_hours;
	}

	public void setTask_working_hours(List<Integer> task_working_hours) {
		this.task_working_hours = task_working_hours;
	}

	public List<String> getProject_name() {
		return project_name;
	}

	public void setProject_name(List<String> project_name) {
		this.project_name = project_name;
	}

	public List<Double> getProject_working_hours() {
		return project_working_hours;
	}

	public void setProject_working_hours(List<Double> project_working_hours) {
		this.project_working_hours = project_working_hours;
	}

	public List<String> getSub_task_name() {
		return sub_task_name;
	}

	public void setSub_task_name(List<String> sub_task_name) {
		this.sub_task_name = sub_task_name;
	}

	public List<Integer> getSub_task_working_hours() {
		return sub_task_working_hours;
	}

	public void setSub_task_working_hours(List<Integer> sub_task_working_hours) {
		this.sub_task_working_hours = sub_task_working_hours;
	}

	public List<String> getModule_name() {
		return module_name;
	}

	public void setModule_name(List<String> module_name) {
		this.module_name = module_name;
	}

	public List<Integer> getModule_working_hours() {
		return module_working_hours;
	}

	public void setModule_working_hours(List<Integer> module_working_hours) {
		this.module_working_hours = module_working_hours;
	}

	public T4_Analytics() {
	}

}