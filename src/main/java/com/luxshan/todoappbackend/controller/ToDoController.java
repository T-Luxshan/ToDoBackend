package com.luxshan.todoappbackend.controller;

import com.luxshan.todoappbackend.dto.ToDoRequest;
import com.luxshan.todoappbackend.service.ToDoServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {


    @Autowired
    private ToDoServiece toDoServiece;


    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody ToDoRequest toDoRequest){
        return toDoServiece.addTask(toDoRequest);
    }

    @GetMapping
    public ResponseEntity<List<ToDoRequest>> getAllTask(){
        List<ToDoRequest> toDoRequests = toDoServiece.getAllTask();
        return  ResponseEntity.ok(toDoRequests);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id){
        return ResponseEntity.ok(toDoServiece.deleteTask(id));
    }

    @PatchMapping("/complete/{id}")
    public ResponseEntity<ToDoRequest> completeTask(@PathVariable Integer id){
      return ResponseEntity.ok(toDoServiece.completeTask(id));
    }

    @PutMapping
    public ResponseEntity<ToDoRequest> editTask(@RequestBody ToDoRequest toDoRequest){
        return ResponseEntity.ok(toDoServiece.editTask(toDoRequest));
    }


}
