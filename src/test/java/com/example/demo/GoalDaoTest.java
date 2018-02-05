package com.example.demo;

import com.example.demo.db.GoalDao;
import com.example.demo.model.GoalUpdate;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoalDaoTest {

    @Autowired
    private GoalDao goalDao;

    @Test
    public void getGoal() {
        goalDao.getGoal();
    }

    @Test
    public void addGoal() {
        GoalUpdate goal = new GoalUpdate();
        goal.setGoals(15);
        goal.setPlayername("Påsan Hansen");
        goal.setTeam("Sleivdal");
        goalDao.addGoal(goal);
    }

}
