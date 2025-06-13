package project.cinemareserve.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cinemareserve.command.LoginCommand;
import project.cinemareserve.command.RegisterCommand;
import project.cinemareserve.command.TokenResponse;
import project.cinemareserve.entity.User;
import project.cinemareserve.exception.InvalidPasswordException;
import project.cinemareserve.exception.UserExistsException;
import project.cinemareserve.jwt.JwtUtill;
import project.cinemareserve.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtill jwtUtill;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(RegisterCommand command) {
        String username = command.getUsername();
        String email = command.getEmail();
        checkIfUserExists(username,email);
        String password = passwordEncoder.encode(command.getPassword());
        User newUser = new User(username, email,password);
        userRepository.save(newUser);
    }

    @Transactional
    public TokenResponse login(LoginCommand loginCommand) {
        UsernamePasswordAuthenticationToken authInPutToken = new UsernamePasswordAuthenticationToken
                (loginCommand.getUsername(), loginCommand.getPassword());
        try {
            authenticationManager.authenticate(authInPutToken);
        } catch (BadCredentialsException e) {

            throw new InvalidPasswordException("Invalid credentials");
        }
        User currentUser = userRepository.findByUsername(loginCommand.getUsername()).orElseThrow(() -> new UsernameNotFoundException(loginCommand.getUsername()));
        userRepository.save(currentUser);
        String accessToken = jwtUtill.generateAccessToken(loginCommand.getUsername());


        return new TokenResponse(accessToken);
    }

    private void checkIfUserExists(String username,String email) {
        if (userRepository.existsByUsernameOrEmail(username,email)) {
            throw new UserExistsException("User already exists");
        }
    }

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


}
