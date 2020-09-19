package novi.spring.projectlocally.repository;

import novi.spring.projectlocally.model.AppUser;
import novi.spring.projectlocally.model.LocationPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationPostRepository extends JpaRepository<LocationPost, Long> {
    LocationPost findTopByOriginalPosterOrderByPostIdDesc(AppUser originalPoster);
}
