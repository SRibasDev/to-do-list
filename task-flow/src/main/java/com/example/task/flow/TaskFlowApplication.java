package com.example.task.flow;

import com.example.task.flow.model.TarefaModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskFlowApplication {

	public static void main(String[] args) {
        TarefaModel data = new TarefaModel();
		SpringApplication.run(TaskFlowApplication.class, args);
	}

}
