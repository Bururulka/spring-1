package com.javarush.service;

import com.javarush.dao.TaskDAO;
import com.javarush.domain.Status;
import com.javarush.domain.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TaskService {
    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public List<Task> getAllTasks(int offset, int limit) {
        return taskDAO.getAllTasks(offset, limit);
    }

    public int getAllTasksCount() {
        return taskDAO.getAllTasksCount();
    }
    @Transactional
    public Task edit(int id, String desc, Status status) {
        Task task = taskDAO.getTaskById(id);
        if(isNull(task)){
            throw new RuntimeException("Task not found");
        }
        task.setDescription(desc);
        task.setStatus(status);
        taskDAO.saveOrUpdateTask(task);
        return task;
    }

    public Task create(String desc, Status status) {
        Task task = new Task();
        task.setDescription(desc);
        task.setStatus(status);
        taskDAO.saveOrUpdateTask(task);
        return task;
    }
    @Transactional
    public Task delete(int id) {
        Task task = taskDAO.getTaskById(id);
        if(isNull(task)){
            throw new RuntimeException("Task not found");
        }
        taskDAO.deleteTask(task);
        return task;
    }

}
