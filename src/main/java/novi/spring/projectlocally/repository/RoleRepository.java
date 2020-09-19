package novi.spring.projectlocally.repository;

import novi.spring.projectlocally.model.ERole;
import novi.spring.projectlocally.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role, Long>{
    Optional<Role> findByName(ERole name);
}
