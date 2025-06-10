package project.cinemareserve.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String username;
    private String email;

    public UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
