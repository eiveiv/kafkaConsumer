package com.example.demo.db;

import com.example.demo.model.GoalUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class GoalDao extends JdbcDaoSupport {

    private static final String SELECT_GOALS = "select * from football.goal";
    private static final String INSERT_GOALS = "insert into football.goal(team, name, number_goals)" +
            "values (?,?,?)";

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void init() {
        setDataSource(dataSource);
    }

    public void addGoal(GoalUpdate goalUpdate) {
        GoalUpdate goal = new GoalUpdate();
        getJdbcTemplate().update(INSERT_GOALS, goalUpdate.getTeam(), goalUpdate.getPlayername(), goalUpdate.getGoals());
    }

    public GoalUpdate getGoal() {
        GoalUpdate goal = new GoalUpdate();

        goal = (GoalUpdate) getJdbcTemplate().queryForObject(SELECT_GOALS, new Object[]{}, new GoalMapper());
        return goal;
    }
}
