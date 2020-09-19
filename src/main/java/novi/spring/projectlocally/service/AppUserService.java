package novi.spring.projectlocally.service;

import novi.spring.projectlocally.Exception.AppUserNotFoundException;
import novi.spring.projectlocally.model.AppUser;
import novi.spring.projectlocally.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService, IAppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser getAppUserById(Long id) {
            return appUserRepository.findById(id)
                    .orElseThrow(() -> new AppUserNotFoundException(id));
    }



//    @Override
//    public String verifyAppUser(String userName) {
//        return "Hi, welkom bij locally! Je bent ingelogd.";
//    }

    @Override
    public AppUser saveAppUser(AppUser newAppUser) {
        String userName = newAppUser.getUsername();
            return appUserRepository.save(newAppUser);
    }

    @Override
    public AppUser updateAppUserById(Long id, AppUser updatedAppUser) {

        Optional<AppUser> userFromDB = appUserRepository.findById(id);

        if (userFromDB.isPresent()){
        String name = updatedAppUser.getUsername();
            if (validUserName(name)) {
                AppUser appUser = new AppUser();
                appUser.setUserName(updatedAppUser.getUsername());
                appUser.setEmail(updatedAppUser.getEmail());
                return appUserRepository.save(appUser);
            }
    }
        return updatedAppUser;
    }

    @Override
    public String deleteAppUserById(Long userId) {
        Optional <AppUser> appUser = appUserRepository.findById(userId);

        if (appUser.isPresent()) {
            appUserRepository.deleteById(userId);
            return "User met id " + appUser.get().getUserId() + " is verwijderd";
        } else {
            throw new AppUserNotFoundException(userId);
        }
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)  {
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Gebruiker bestaat niet: " + username));
        return AppUserDetailsImpl.build(user);
    }
//    private boolean AppUserExistsInDB(String userName, String password){
//       if (userName.equals(AppUser.getUserName()) && password.equals(AppUser.getPassword()) {
//           return true;
//        }
//        return false;
//    }

    //Validatie methode voor username
    private boolean validUserName(String name){
        if (name.equals("")) {
            return false;
        }
        return true;
    }


}
