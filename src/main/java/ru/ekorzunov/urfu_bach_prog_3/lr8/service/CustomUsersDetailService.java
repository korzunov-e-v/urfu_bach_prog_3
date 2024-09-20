package ru.ekorzunov.urfu_bach_prog_3.lr8.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr8.entity.Role;
import ru.ekorzunov.urfu_bach_prog_3.lr8.entity.User;
import ru.ekorzunov.urfu_bach_prog_3.lr8.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUsersDetailService implements UserDetailsService {

    private UserRepository userRepository;


    public CustomUsersDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(usernameOrEmail);
        if (user != null) {
            List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                    .map((role) -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    authorities
            );
        } else {
            throw new UsernameNotFoundException("Invalid email or password.");
        }

    }
}
