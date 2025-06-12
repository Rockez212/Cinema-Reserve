package project.cinemareserve.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import project.cinemareserve.dtos.UserDto;
import project.cinemareserve.entity.User;

@Data
@AllArgsConstructor
public class UserMapper {

    public static UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(user.getUsername(), user.getEmail());
    }
}
