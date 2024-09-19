package ru.ekorzunov.urfu_bach_prog_3.lr6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ekorzunov.urfu_bach_prog_3.lr6.entity.Student;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.NotFoundException;

import java.util.List;


@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student createStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student updateStudent(Student student) throws NotFoundException {
        Student existingStudent = getStudent(student.getId());
        if (existingStudent == null) {
            throw new NotFoundException("Student not found.");
        }
        return entityManager.merge(student);
    }

    @Override
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public int deleteStudent(int id) {
        Query query = entityManager.createQuery("delete from Student "
                + "where id =:studentId");
        query.setParameter("studentId", id);
        return query.executeUpdate();
    }
}
