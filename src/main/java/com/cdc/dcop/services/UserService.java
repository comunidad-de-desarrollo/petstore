package com.cdc.dcop.services;

import com.cdc.dcop.dto.UserDTO;
import com.cdc.dcop.entity.User;
import com.cdc.dcop.models.LoginResponse;
import com.cdc.dcop.repository.UserRepository;
import com.cdc.dcop.utils.PetstoreValidation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	public LoginResponse login(String username, String password) {
		LoginResponse response = new LoginResponse();
		User entity = userRepository.findByUsernameAndPassword(username, password).orElse(null);
		if(entity != null) {
			Random rand = new Random();
			response.setActive(true);
			response.setSession(rand.nextInt(50));
		}
		else {
			PetstoreValidation.notLogged().lanzar();
		}
		
		return response;
	}
    public Boolean login(String username, String password) {
        User entity = userRepository.findByUsernameAndPassword(username, password).orElse(null);
        return entity != null;
    }
    
    public Boolean logout(String session) {
        //User entity = userRepository.findByUsernameAndPassword(username, password).orElse(null);
    	System.out.println("Session " + session + " logout");
        return true;
    }
    
    public UserDTO username(String username) {
    	User user = userRepository.findByUsername(username).orElse(null);
    	return mapper.map(user, UserDTO.class);
    }
    
    public boolean updateUser(String username, UserDTO updatedUser) {
    	User user = userRepository.findByUsername(username).orElse(null);
    	if (user != null) {
    		User entity = mapper.map(updatedUser, User.class);
            entity = userRepository.save(entity);
            
            return true;
    	}
    	return false;
    }
    
    public boolean delete(String username) {
    	User user = userRepository.findByUsername(username).orElse(null);
    	if (user != null) {
    		User entity = mapper.map(user, User.class);
    		userRepository.delete(entity);
    		return true;
    	}
    	return false;
    }
}
