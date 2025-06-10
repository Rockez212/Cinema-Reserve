package project.cinemareserve.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cinemareserve.command.LoginCommand;
import project.cinemareserve.command.TokenResponse;
import project.cinemareserve.entity.User;
import project.cinemareserve.jwt.JwtUtill;
import project.cinemareserve.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtill jwtUtill;
    


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
        String username = currentUser.getUsername();
        userRepository.save(currentUser);
        String accessToken = jwtUtill.generateAccessToken(loginCommand.getUsername());


        return new TokenResponse(accessToken);
    }

}
