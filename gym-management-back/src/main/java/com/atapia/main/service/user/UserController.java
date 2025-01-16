package com.atapia.main.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atapia.main.business.UserService;
import com.atapia.main.dto.UserDTO;
import com.atapia.main.service.user.response.ResponseGetAll;
import com.atapia.main.service.user.response.ResponseDelete;
import com.atapia.main.service.user.request.RequestInsert;
import com.atapia.main.service.user.request.RequestLogin;
import com.atapia.main.service.user.response.ResponseInsert;
import com.atapia.main.service.user.response.ResponseLogin;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "insert", consumes = { "multipart/form-data" })
	public ResponseEntity<ResponseInsert> actionInsert(@Valid @ModelAttribute RequestInsert soInsert, BindingResult bindingResult) {
		ResponseInsert responseInsert = new ResponseInsert();

		try {
			if(bindingResult.hasErrors()) {
				bindingResult.getAllErrors().forEach(error -> {
					responseInsert.addResponseMesssage(error.getDefaultMessage());
				});
				
				return new ResponseEntity<>(responseInsert, HttpStatus.OK);
			}

			UserDTO dtouser = new UserDTO();

			dtouser.setNameUser(soInsert.getNameUser());
			dtouser.setEmail(soInsert.getEmail());
			dtouser.setPassword(soInsert.getPassword());
			dtouser.setRol(soInsert.getRol());
			dtouser.setState(soInsert.getState());

            
			userService.insertUser(dtouser);

			responseInsert.success();
			responseInsert.addResponseMesssage("Operación realizada correctamente.");

			return new ResponseEntity<>(responseInsert, HttpStatus.CREATED);
		} catch(Exception e) {
			responseInsert.exception();
			responseInsert.addResponseMesssage("Ocurrió un error inesperado, estamos trabajando para solucionarlo.");

			return new ResponseEntity<>(responseInsert, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path = "getall")
	public ResponseEntity<ResponseGetAll> actionGetAll() {
		ResponseGetAll responseGetAll = new ResponseGetAll();

		List<UserDTO> listdtouser = userService.getAllUsers();

		for (UserDTO dtouser : listdtouser) {
			Map<String, Object> map = new HashMap<>();

			map.put("idUser", dtouser.getIdUser());
			map.put("nameUser", dtouser.getNameUser());
			map.put("email", dtouser.getEmail());
			map.put("password", dtouser.getPassword());
            map.put("rol", dtouser.getRol());
            map.put("state", dtouser.getState());

			responseGetAll.dto.listUser.add(map);
		}

		responseGetAll.success();

		return new ResponseEntity<>(responseGetAll, HttpStatus.OK);
	}

	@DeleteMapping(path = "delete/{iduser}")
	public ResponseEntity<ResponseDelete> actionDelete(@PathVariable String idUser) {
		ResponseDelete responseDelete = new ResponseDelete();

		userService.deleteUser(idUser);

		responseDelete.success();
		responseDelete.addResponseMesssage("Operación realizada correctamente.");

		return new ResponseEntity<>(responseDelete, HttpStatus.OK);
	}

	@PostMapping(path = "login", consumes = { "multipart/form-data" })
	public ResponseEntity<ResponseLogin> actionLogin(@Valid @ModelAttribute RequestLogin soLogin, BindingResult bindingResult) {
        ResponseLogin responseLogin = new ResponseLogin();

		UserDTO dtoUser = userService.getLogin(soLogin.getNameUser(), soLogin.getPassword());

		if(dtoUser == null) {
			responseLogin.addResponseMesssage("Usuario o contraseña incorrecta.");

			return new ResponseEntity<>(responseLogin, HttpStatus.OK);
		}

		Map<String, Object> map = new HashMap<>();

		map.put("idUser", dtoUser.getIdUser());
		map.put("userName", dtoUser.getNameUser());
		map.put("rol",dtoUser.getRol());

		responseLogin.dto.user = map;

		responseLogin.addResponseMesssage("Bienvenido(a) al sistema.");
		responseLogin.success();

		return new ResponseEntity<>(responseLogin, HttpStatus.OK);
	}

    

    

}
