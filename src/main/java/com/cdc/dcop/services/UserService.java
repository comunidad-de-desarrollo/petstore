package com.cdc.dcop.services;

import com.cdc.dcop.dto.UserDTO;
import com.cdc.dcop.entity.User;
import com.cdc.dcop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper mapper = new ModelMapper();

    public UserDTO create(UserDTO userDTO) {
        User entity = mapper.map(userDTO, User.class);
        entity = userRepository.save(entity);
        return mapper.map(entity, UserDTO.class);
    }

    public List<UserDTO> createAll(List<UserDTO> userDTOs) {
        List<User> entities = new ArrayList<>();
        for (UserDTO dto : userDTOs) {
            entities.add(mapper.map(dto, User.class));
        }
        entities = userRepository.saveAll(entities);
        userDTOs = new ArrayList<>();
        for (User entity : entities) {
            userDTOs.add(mapper.map(entity, UserDTO.class));
        }
        return userDTOs;
    }

    public Boolean login(String username, String password) {
        User entity = userRepository.findByUsernameAndPassword(username, password).orElse(null);
        return entity != null;
    }
}
