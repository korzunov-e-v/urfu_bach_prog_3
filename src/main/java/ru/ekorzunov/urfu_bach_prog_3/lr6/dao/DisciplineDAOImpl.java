package ru.ekorzunov.urfu_bach_prog_3.lr6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ekorzunov.urfu_bach_prog_3.lr6.entity.Discipline;
import ru.ekorzunov.urfu_bach_prog_3.lr6.exception.NotFoundException;

import java.util.List;


@Slf4j
@Repository
public class DisciplineDAOImpl implements DisciplineDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Discipline> getAllDisciplines() {
        TypedQuery<Discipline> query = entityManager.createQuery("select d from Discipline d", Discipline.class);
        return query.getResultList();
    }

    @Override
    public Discipline createDiscipline(Discipline Discipline) {
        return entityManager.merge(Discipline);
    }

    @Override
    public Discipline updateDiscipline(Discipline Discipline) throws NotFoundException {
        Discipline existingDiscipline = getDiscipline(Discipline.getId());
        if (existingDiscipline == null) {
            throw new NotFoundException("Discipline not found.");
        }
        return entityManager.merge(Discipline);
    }

    @Override
    public Discipline getDiscipline(int id) {
        return entityManager.find(Discipline.class, id);
    }

    @Override
    public int deleteDiscipline(int id) {
        Query query = entityManager.createQuery("delete from Discipline "
                + "where id =:DisciplineId");
        query.setParameter("DisciplineId", id);
        return query.executeUpdate();
    }
}
