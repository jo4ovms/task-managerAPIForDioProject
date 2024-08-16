package com.jo4ovms.taskmanager.controller;


import com.jo4ovms.taskmanager.builder.TaskBuilder;
import com.jo4ovms.taskmanager.model.Task;
import com.jo4ovms.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PostMapping("/build")
    public Task createTaskWithBuilder(@RequestParam String title,
                                      @RequestParam String description,
                                      @RequestParam int priority,
                                      @RequestParam boolean completed) {

        Task task = new TaskBuilder()
                .setTitle(title)
                .setDescription(description)
                .setPriority(priority)
                .setCompleted(completed)
                .build();

        return taskService.createTask(task);

    }



}
