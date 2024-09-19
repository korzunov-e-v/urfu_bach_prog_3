package ru.ekorzunov.urfu_bach_prog_3.lr6.service;

import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr6.entity.Student;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.CreationException;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.NotFoundException;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudents();

    Student createStudent(Student student) throws CreationException;

    Student updateStudent(Student student) throws NotFoundException;

    Student getStudent(int id) throws NotFoundException;

    int deleteStudent(int id) throws NotFoundException;

}
