package ru.ekorzunov.urfu_bach_prog_3.lr6.dao;

import ru.ekorzunov.urfu_bach_prog_3.lr6.entity.Discipline;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.NotFoundException;

import java.util.List;

public interface DisciplineDAO {

    List<Discipline> getAllDisciplines();

    Discipline createDiscipline(Discipline Discipline);

    Discipline updateDiscipline(Discipline Discipline) throws NotFoundException;

    Discipline getDiscipline(int id);

    int deleteDiscipline(int id);

}
