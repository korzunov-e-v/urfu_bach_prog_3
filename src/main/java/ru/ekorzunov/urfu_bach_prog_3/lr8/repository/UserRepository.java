package ru.ekorzunov.urfu_bach_prog_3.lr8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ekorzunov.urfu_bach_prog_3.lr8.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
