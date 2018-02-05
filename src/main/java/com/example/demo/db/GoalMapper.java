package com.example.demo.db;

import com.example.demo.model.GoalUpdate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoalMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        GoalUpdate goalUpdate = new GoalUpdate();
        goalUpdate.setGoals(resultSet.getInt("number_goals"));
        goalUpdate.setPlayername(resultSet.getString("name"));
        goalUpdate.setTeam(resultSet.getString("team"));

        return goalUpdate;
    }
}
