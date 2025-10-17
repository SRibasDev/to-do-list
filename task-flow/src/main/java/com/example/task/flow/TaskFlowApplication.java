package com.example.task.flow;

import com.example.task.flow.model.TaskModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskFlowApplication {

	public static void main(String[] args) {
        TaskModel data = new TaskModel();
		SpringApplication.run(TaskFlowApplication.class, args);
	}

}
