package ru.ekorzunov.urfu_bach_prog_3.lr7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ekorzunov.urfu_bach_prog_3.lr7.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
