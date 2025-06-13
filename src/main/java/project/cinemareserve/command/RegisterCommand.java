package project.cinemareserve.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterCommand {
    @NotBlank(message = "username is mandatory")
    private String username;
    @Email(message = "Incorrect email address")
    private String email;
    @Size(min = 6, max = 8, message = "The password must contain from 6 to 8 characters.")
    @NotBlank(message = "password is mandatory")
    private String password;
}
