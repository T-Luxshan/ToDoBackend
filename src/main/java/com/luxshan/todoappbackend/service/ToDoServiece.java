package com.luxshan.todoappbackend.service;

import com.luxshan.todoappbackend.dto.ToDoRequest;
import com.luxshan.todoappbackend.entity.ToDo;
import com.luxshan.todoappbackend.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiece {

    @Autowired
    private ToDoRepository toDoRepository;
    public ResponseEntity<String> addTask(ToDoRequest toDoRequest) {
        try {
            ToDo toDo = ToDo.builder()
                    .task(toDoRequest.getTask())
                    .completed((toDoRequest.isCompleted()))
                    .build();
            toDoRepository.save(toDo);
            return new ResponseEntity<>("Done", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Task failed successfully", HttpStatus.BAD_REQUEST);
        }

    }

    public List<ToDoRequest> getAllTask() {

        // Fetching all the task from the db
        List<ToDo> toDos  = toDoRepository.findAll();

        //Map the task into DTO
        return toDos.stream()
                .map(toDo -> ToDoRequest.builder()
                        .id(toDo.getId())
                        .task(toDo.getTask())
                        .completed(toDo.isCompleted())
                        .build())
                .toList();

    }

    public String deleteTask(Integer id) {
        try{
            toDoRepository.deleteById(id);
            return "Deletion successful";
        }
        catch (Exception e){
            return "Deletion failed";
        }
    }

    public ToDoRequest completeTask(Integer id) {
        Optional<ToDo> toDoTemp = toDoRepository.findById(id);

        if(toDoTemp.isPresent()) {
            ToDo toDo = toDoTemp.get();
            toDo.setCompleted(true);
            toDoRepository.save(toDo);

            return ToDoRequest.builder()
                    .id(toDo.getId())
                    .completed(toDo.isCompleted())
                    .task(toDo.getTask())
                    .build();
        }
        else {
            return new ToDoRequest();
        }



    }

    public ToDoRequest editTask(ToDoRequest toDoRequest) {
        Optional<ToDo> toDoTemp = toDoRepository.findById(toDoRequest.getId());

        if(toDoTemp.isPresent()){
            ToDo toDo = toDoTemp.get();
            toDo.setTask(toDoRequest.getTask());
            toDo.setCompleted(toDoRequest.isCompleted());

            toDoRepository.save(toDo);

            return ToDoRequest.builder()
                    .task(toDo.getTask())
                    .completed(toDo.isCompleted())
                    .build();
        }
        return new ToDoRequest();
    }
}
