package novi.spring.projectlocally.controller;

import novi.spring.projectlocally.payload.request.SignupRequest;
import novi.spring.projectlocally.payload.response.JwtResponse;
import novi.spring.projectlocally.payload.request.LoginRequest;
import novi.spring.projectlocally.payload.response.MessageResponse;
import novi.spring.projectlocally.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authorizationService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
        return authorizationService.registerUser(signUpRequest);
    }
}
