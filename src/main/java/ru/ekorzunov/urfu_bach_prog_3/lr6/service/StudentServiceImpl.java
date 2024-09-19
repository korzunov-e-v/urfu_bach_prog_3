package ru.ekorzunov.urfu_bach_prog_3.lr6.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr6.dao.StudentDAO;
import ru.ekorzunov.urfu_bach_prog_3.lr6.entity.Student;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.CreationException;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.NotFoundException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student createStudent(Student student) throws CreationException {
        if (student.getId() != 0) {
            throw new CreationException("attempt to create instance with id field");
        }
        return studentDAO.createStudent(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) throws NotFoundException {
        return studentDAO.updateStudent(student);
    }

    @Override
    @Transactional
    public Student getStudent(int id) throws NotFoundException {
        Student student = studentDAO.getStudent(id);
        if (student == null) {
            throw new NotFoundException("Student not found.");
        }
        return student;
    }

    @Override
    @Transactional
    public int deleteStudent(int id) throws NotFoundException {
        int deleted = studentDAO.deleteStudent(id);
        if (deleted == 0) {
            throw new NotFoundException("Student not found.");
        }
        return deleted;
    }
}
