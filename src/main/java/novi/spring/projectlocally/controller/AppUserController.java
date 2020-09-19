package novi.spring.projectlocally.controller;

import novi.spring.projectlocally.model.AppUser;
import novi.spring.projectlocally.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@ResponseStatus (value= HttpStatus.CREATED)
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;


//    @GetMapping(value = "/api/appuser")
//    public Iterable<AppUser> getAppUsers() {
//        Iterable<AppUser> appUserList = appUserRepository.findAll();
//        return appUserList;
//    }

    //Methode is alleen verantwoordelijk voor het ontvangen van userId en die geeft het door aan de service-klasse
    @GetMapping(value = "/api/appuser/{id}")
    public AppUser getAppUserById(@PathVariable Long id)
    {
        return appUserService.getAppUserById(id);
    }

//    @PostMapping(value="/api/appuser/login")
//    public String verifyAppUser(@RequestBody String userName) {
//        return appUserService.verifyAppUser(userName);
//    }

    @PostMapping(value="/api/appuser/signup")
    public AppUser saveAppUser(@RequestBody AppUser newAppUser) {
        return appUserService.saveAppUser(newAppUser);
    }

    @PutMapping(value="/api/appuser/{id}")
    public AppUser updateAppUserById(@PathVariable long id, @RequestBody AppUser updatedAppUser) {
        return appUserService.updateAppUserById(id, updatedAppUser);
    }

    @DeleteMapping("/api/appuser/{id}")
    public String deleteAppUserById(@PathVariable long id) {
        return appUserService.deleteAppUserById(id);
    }




}
