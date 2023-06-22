package com.nkxgen.spring.controller;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.nkxgen.spring.orm.model.T4_Analytics;

@Controller
public class AnalyticsController {


	@RequestMapping(value = "/getProjAnaById", method = RequestMethod.POST)
	public @ResponseBody String getProjAnalysisById(@RequestParam("user_id") Integer user_id) throws SQLException {
		String query = "SELECT p.proj_id, p.proj_name, ABS(SUM(EXTRACT(EPOCH FROM (t.task_cmp_datetime - t.task_cdatetime))) / 3600) AS total_working_hours "
				+ "FROM T4_Projects p " + "JOIN T4_ProjectTasks pt ON p.proj_id = pt.proj_id "
				+ "JOIN T4_Tasks t ON pt.task_id = t.task_id " + "WHERE pt.task_user_id = ? "
				+ "GROUP BY p.proj_id, p.proj_name";
		Map<String, Integer> projectWorkingHoursMap = new HashMap<>();

		T4_Analytics an = new T4_Analytics();

			projectWorkingHoursMap.put("hi", 1);
		Gson gson = new Gson();
		String json = gson.toJson(projectWorkingHoursMap);

		System.out.println(user_id + "\n" + json);
		return json;
		// return projectWorkingHoursMap;
	}

	/*
	 * @RequestMapping(value = "/getModlAnaById", method = RequestMethod.POST)
	 * public @ResponseBody String getModlAnalysisById(@RequestParam("user_id")
	 * Integer user_id) throws SQLException { String query =
	 * "SELECT p.proj_id, p.proj_name, ABS(SUM(EXTRACT(EPOCH FROM (t.task_cmp_datetime - t.task_cdatetime))) / 3600) AS total_working_hours "
	 * + "FROM T4_Projects p " +
	 * "JOIN T4_ProjectTasks pt ON p.proj_id = pt.proj_id " +
	 * "JOIN T4_Tasks t ON pt.task_id = t.task_id " + "WHERE pt.task_user_id = ? " +
	 * "GROUP BY p.proj_id, p.proj_name"; Map<String, Integer>
	 * projectWorkingHoursMap = new HashMap<>(); statement =
	 * connection.prepareStatement(query); statement.setInt(1, user_id); ResultSet
	 * rs = statement.executeQuery(); T4_Analytics an = new T4_Analytics(); while
	 * (rs.next()) { rs.getInt("proj_id"); String project_name =
	 * rs.getString("proj_name"); double project_working_hours =
	 * rs.getDouble("total_working_hours"); an.setProject_name(project_name);
	 * an.setProject_working_hours(project_working_hours); // Do something with the
	 * retrieved data projectWorkingHoursMap.put(project_name, (int)
	 * project_working_hours); } Gson gson = new Gson(); String json =
	 * gson.toJson(projectWorkingHoursMap);
	 * 
	 * System.out.println(user_id + "\n" + json); return json; // return
	 * projectWorkingHoursMap; }
	 */
	
}
