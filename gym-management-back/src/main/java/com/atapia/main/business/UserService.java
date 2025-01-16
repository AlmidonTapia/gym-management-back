package com.atapia.main.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atapia.main.dto.UserDTO;
import com.atapia.main.entity.TUser;
import com.atapia.main.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired

    private UserRepository userRepository;

    @Transactional
    public boolean insertUser(UserDTO dtoUser){

        dtoUser.setIdUser(UUID.randomUUID().toString());
        dtoUser.setCreatedAt(new Date());
        dtoUser.setUpdatedAt(new Date());
        
        TUser tUser = new TUser();

        tUser.setIdUser(dtoUser.getIdUser());
        tUser.setNameUser(dtoUser.getNameUser());
        tUser.setEmail(dtoUser.getEmail());
        tUser.setPassword(dtoUser.getPassword());
        tUser.setRol(dtoUser.getRol());
        tUser.setState(dtoUser.getState());
        tUser.setCreatedAt(dtoUser.getCreatedAt());
        tUser.setUpdatedAt(dtoUser.getUpdatedAt());

        userRepository.save(tUser);

        return true;        
    }

    public List<UserDTO> getAllUsers(){
        List<TUser> listTUser= userRepository.findAll();

		List<UserDTO> listDtoUser = new ArrayList<>();

		for (TUser tUser : listTUser) {
			UserDTO dtoUser = new UserDTO();

			dtoUser.setIdUser(tUser.getIdUser());
            dtoUser.setNameUser(tUser.getNameUser());
            dtoUser.setEmail(tUser.getEmail());
            dtoUser.setPassword(tUser.getPassword());
            dtoUser.setRol(tUser.getRol());
            dtoUser.setState(tUser.getState());
            dtoUser.setCreatedAt(tUser.getCreatedAt());
            dtoUser.setUpdatedAt(tUser.getUpdatedAt());

			listDtoUser.add(dtoUser);
		}
		
		return listDtoUser;
    }

    @Transactional
    public boolean deleteUser(String idUser){
        userRepository.deleteById(idUser);
        return true;
    }

    @Transactional
    public boolean updateUser(UserDTO dtoUser){
        TUser tUser = new TUser();

        tUser.setIdUser(dtoUser.getIdUser());
        tUser.setNameUser(dtoUser.getNameUser());
        tUser.setEmail(dtoUser.getEmail());
        tUser.setPassword(dtoUser.getPassword());
        tUser.setRol(dtoUser.getRol());
        tUser.setState(dtoUser.getState());
        tUser.setCreatedAt(dtoUser.getCreatedAt());
        tUser.setUpdatedAt(dtoUser.getUpdatedAt());

        userRepository.save(tUser);

        return true;
    }

    public UserDTO getLogin(String userName, String password) {
        TUser tUser = userRepository.getLogin(userName, password);

        if (tUser == null) {
            return null;
        }

        UserDTO dtoUser = new UserDTO();

        dtoUser.setIdUser(tUser.getIdUser());
        dtoUser.setNameUser(tUser.getNameUser());
        dtoUser.setRol(tUser.getRol());
        dtoUser.setCreatedAt(tUser.getCreatedAt());
        dtoUser.setUpdatedAt(tUser.getUpdatedAt());

        return dtoUser;
    }

}
