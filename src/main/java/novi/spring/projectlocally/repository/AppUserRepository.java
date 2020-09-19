package novi.spring.projectlocally.repository;

import novi.spring.projectlocally.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<AppUser> findByUsername(String username);
}

