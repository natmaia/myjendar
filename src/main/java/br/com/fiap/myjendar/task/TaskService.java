package br.com.fiap.myjendar.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService{

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}