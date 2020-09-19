//package novi.spring.projectlocally.controller;
//
//import novi.spring.projectlocally.repository.AppUserRepository;
//import novi.spring.projectlocally.repository.LocationPostRepository;
//import novi.spring.projectlocally.repository.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class DatabaseLoader implements CommandLineRunner {
//
//    @Autowired
//    private final AppUserRepository appUserRepository;
//
//    @Autowired
//    private final RoleRepository roleRepository;
//
//    @Autowired
//    private final LocationPostRepository locationPostRepository;
//
//    //constructor die door @Autowired aangemaakt wordt
//    public DatabaseLoader
//    (
//            AppUserRepository appUserRepository,
//            RoleRepository roleRepository,
//            LocationPostRepository locationPostRepository
//    )
//    {
//        this.appUserRepository = appUserRepository;
//        this.roleRepository = roleRepository;
//        this.locationPostRepository = locationPostRepository;
//    }
//
//
//
//    @Override
//    public void run(String... args) throws Exception {
//            //onderstaande line is alleen voor testpersonen, nieuwe users toevoegen werkt. Voor de beoordeling moet deze functie aan staan zodat docent het kan testen!
//
//            //appUserRepository.save(new AppUser("Willem", "Wever", "willemw@casema.nl", "Willempie", "welkom123"));
//    }
//}
