package com.exemplo.taskboard.controller;

import com.exemplo.taskboard.model.Tarefa;
import com.exemplo.taskboard.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaRepository.findAll();
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa nova) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow();
        tarefa.setTitulo(nova.getTitulo());
        tarefa.setDescricao(nova.getDescricao());
        tarefa.setStatus(nova.getStatus());
        return tarefaRepository.save(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
    }
}