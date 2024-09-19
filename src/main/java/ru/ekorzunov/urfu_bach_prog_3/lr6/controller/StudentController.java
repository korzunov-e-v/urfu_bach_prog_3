package ru.ekorzunov.urfu_bach_prog_3.lr6.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ekorzunov.urfu_bach_prog_3.lr6.entity.Student;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.CreationException;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.NotFoundException;
import ru.ekorzunov.urfu_bach_prog_3.lr6.service.StudentService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
        JSONObject resp = new JSONObject();
        Student student;

        try {
            student = studentService.getStudent(id);
        } catch (NotFoundException e) {
            String message = String.format("student with id=%d not found.", id);
            resp.put("message", message);
            return new ResponseEntity<>(resp.toMap(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        try {
            student = studentService.createStudent(student);
        } catch (CreationException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", "id field not allowed");
            return new ResponseEntity<>(resp.toMap(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/students")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        JSONObject resp = new JSONObject();
        HttpStatus httpStatus;
        String message;

        try {
            student = studentService.updateStudent(student);
        } catch (NotFoundException e) {
            message = String.format("student with id=%d not found.", student.getId());
            resp.put("message", message);
            httpStatus = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(resp.toMap(), httpStatus);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        int deleted;
        JSONObject resp = new JSONObject();
        HttpStatus httpStatus;
        String message;

        try {
            deleted = studentService.deleteStudent(id);
            message = String.format("student with id=%d deleted.", id);
            httpStatus = HttpStatus.GONE;
        } catch (NotFoundException e) {
            deleted = 0;
            message = String.format("student with id=%d not found.", id);
            httpStatus = HttpStatus.NOT_FOUND;
        }

        resp.put("message", message);
        resp.put("deleted_count", deleted);
        return new ResponseEntity<>(resp.toMap(), httpStatus);
    }

}
