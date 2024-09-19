package ru.ekorzunov.urfu_bach_prog_3.lr6.service;

import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr6.entity.Discipline;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.CreationException;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.NotFoundException;

import java.util.List;

@Service
public interface DisciplineService {

    List<Discipline> getAllDisciplines();

    Discipline createDiscipline(Discipline Discipline) throws CreationException;

    Discipline updateDiscipline(Discipline Discipline) throws NotFoundException;

    Discipline getDiscipline(int id) throws NotFoundException;

    int deleteDiscipline(int id) throws NotFoundException;

}
