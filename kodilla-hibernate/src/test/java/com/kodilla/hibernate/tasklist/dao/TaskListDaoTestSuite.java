package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private String LIST_NAME = "List1";
    private static final String DESCRIPTION = "Description 1";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);
        //When
        taskListDao.save(taskList);
        //Then
        List<TaskList> readTaskList = taskListDao.findByListName(LIST_NAME);
        Assert.assertEquals(1, readTaskList.size());
        //CleanUp
        taskListDao.delete(taskList);
    }
}
