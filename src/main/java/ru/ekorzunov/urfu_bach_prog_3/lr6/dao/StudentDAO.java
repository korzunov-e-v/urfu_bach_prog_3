package ru.ekorzunov.urfu_bach_prog_3.lr6.dao;

import ru.ekorzunov.urfu_bach_prog_3.lr6.entity.Student;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.NotFoundException;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();

    Student createStudent(Student student);

    Student updateStudent(Student student) throws NotFoundException;

    Student getStudent(int id);

    int deleteStudent(int id);

}
