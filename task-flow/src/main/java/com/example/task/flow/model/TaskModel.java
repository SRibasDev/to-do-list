package com.example.task.flow.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_usuarios")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tarefa;
    private String status;
    private LocalDate data = LocalDate.now();

    public TaskModel(){}

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }
    public Long getId(){
        return id;
    }

}
