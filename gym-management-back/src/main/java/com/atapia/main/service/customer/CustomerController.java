package com.atapia.main.service.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atapia.main.business.CustomerService;
import com.atapia.main.dto.CustomerDTO;
import com.atapia.main.service.customer.request.RequestInsert;
import com.atapia.main.service.customer.request.RequestUpdate;
import com.atapia.main.service.customer.response.ResponseDelete;
import com.atapia.main.service.customer.response.ResponseGetAll;
import com.atapia.main.service.customer.response.ResponseInsert;
import com.atapia.main.service.customer.response.ResponseUpdate;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

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

			CustomerDTO dtocustomer = new CustomerDTO();

			dtocustomer.setFirstName(soInsert.getFirstName());
			dtocustomer.setSurName(soInsert.getSurName());
			dtocustomer.setDni(soInsert.getDni());
			dtocustomer.setPhone(soInsert.getPhone());
			dtocustomer.setAge(soInsert.getAge());
			dtocustomer.setGender(soInsert.getGender());
			dtocustomer.setState(soInsert.getState());

            
			customerService.insertCustomer(dtocustomer);

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

		List<CustomerDTO> listdtocustomer = customerService.getAllCustomers();

		for (CustomerDTO dtocustomer : listdtocustomer) {
			Map<String, Object> map = new HashMap<>();

			map.put("idCustomer", dtocustomer.getIdCustomer());
			map.put("firstName", dtocustomer.getFirstName());
			map.put("surName", dtocustomer.getSurName());
			map.put("dni", dtocustomer.getDni());
            map.put("phone", dtocustomer.getPhone());
            map.put("age", dtocustomer.getAge());
			map.put("gender", dtocustomer.getGender());
            map.put("state", dtocustomer.getState());

			responseGetAll.dto.listCustomer.add(map);
		}

		responseGetAll.success();

		return new ResponseEntity<>(responseGetAll, HttpStatus.OK);
	}

	@DeleteMapping(path = "delete/{idCustomer}")
	public ResponseEntity<ResponseDelete> actionDelete(@PathVariable String idCustomer) {
		ResponseDelete responseDelete = new ResponseDelete();

		customerService.deleteCustomer(idCustomer);

		responseDelete.success();
		responseDelete.addResponseMesssage("Operación realizada correctamente.");

		return new ResponseEntity<>(responseDelete, HttpStatus.OK);
	}

	@PostMapping(path = "update", consumes = { "multipart/form-data" })
	public ResponseEntity<ResponseUpdate> actionUpdate(@ModelAttribute RequestUpdate soUpdate) {
		ResponseUpdate responseUpdate = new ResponseUpdate();

		try {
			CustomerDTO dtocustomer = new CustomerDTO();

			dtocustomer.setFirstName(soUpdate.getFirstName());
            dtocustomer.setSurName(soUpdate.getSurName());
            dtocustomer.setDni(soUpdate.getDni());
            dtocustomer.setPhone(soUpdate.getPhone());
            dtocustomer.setAge(soUpdate.getAge());
            dtocustomer.setGender(soUpdate.getGender());
            dtocustomer.setState(soUpdate.getState());

			customerService.updateCustomer(dtocustomer);

			responseUpdate.success();
			responseUpdate.addResponseMesssage("Operación realizada correctamente.");

			return new ResponseEntity<>(responseUpdate, HttpStatus.OK);
		} catch(Exception e) {
			responseUpdate.exception();
			responseUpdate.addResponseMesssage("Ocurrió un error inesperado, estamos trabajando para solucionarlo.");

			return new ResponseEntity<>(responseUpdate, HttpStatus.BAD_REQUEST);
		}
	}

}
