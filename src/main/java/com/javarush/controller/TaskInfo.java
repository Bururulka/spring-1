package com.javarush.controller;

import com.javarush.domain.Status;

public class TaskInfo {
    private String description;
    private String status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
