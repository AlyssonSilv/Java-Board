package com.exemplo.taskboard.repository;

import com.exemplo.taskboard.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}