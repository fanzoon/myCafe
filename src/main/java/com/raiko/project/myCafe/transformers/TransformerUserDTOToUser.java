package com.raiko.project.myCafe.transformers;

import com.raiko.project.myCafe.dtos.UserDTO;
import com.raiko.project.myCafe.models.User;
import org.springframework.stereotype.Component;

@Component
public class TransformerUserDTOToUser {
    public User transform(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurName(userDTO.getSurName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setBirthday(userDTO.getBirthday());
        return  user;
    }
}
