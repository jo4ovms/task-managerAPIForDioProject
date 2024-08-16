package com.jo4ovms.taskmanager.builder;

import com.jo4ovms.taskmanager.model.Task;

public class TaskBuilder {

    private String title;
    private String description;
    private int priority;
    private boolean completed;

    public TaskBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public TaskBuilder setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }

    public Task build() {
        return new Task(title, description, priority, completed);
    }
}
