package novi.spring.projectlocally.Exception;

public class AppUserNotFoundException extends RuntimeException{

    public AppUserNotFoundException(Long id) {
        super("Gebruiker met id: " + id + " bestaat niet.");
    }
}
