package novi.spring.projectlocally.service;

import novi.spring.projectlocally.model.AppUser;
import novi.spring.projectlocally.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService{

    AppUserRepository appUserRepository ;

    @Autowired
    public AppUserDetailsServiceImpl(AppUserRepository userRepository) {
        this.appUserRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)  {
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Gebruiker bestaat niet: " + username));
        return AppUserDetailsImpl.build(user);
    }
}
