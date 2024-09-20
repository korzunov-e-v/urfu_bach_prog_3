package ru.ekorzunov.urfu_bach_prog_3.lr8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ekorzunov.urfu_bach_prog_3.lr8.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
