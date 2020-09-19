package novi.spring.projectlocally.service;

import novi.spring.projectlocally.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

public interface IAppUserService {

    AppUser getAppUserById(Long id);
    AppUser saveAppUser(AppUser newAppUser);
    AppUser updateAppUserById(Long id, AppUser updatedAppUser);
    String deleteAppUserById(Long id);

    @Transactional
    UserDetails loadUserByUsername(String username);
//    String verifyAppUser(String userName);

}
