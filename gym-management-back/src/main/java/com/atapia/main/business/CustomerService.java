package com.atapia.main.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atapia.main.dto.CustomerDTO;
import com.atapia.main.entity.TCustomer;
import com.atapia.main.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

   @Transactional
   public boolean insertCustomer(CustomerDTO dtoCustomer){

        dtoCustomer.setIdCustomer(UUID.randomUUID().toString());
        dtoCustomer.setCreatedAt(new Date());
        dtoCustomer.setUpdatedAt(new Date());
        TCustomer tCustomer = new TCustomer();

        tCustomer.setIdCustomer(dtoCustomer.getIdCustomer());
        tCustomer.setFirstName(dtoCustomer.getFirstName());
        tCustomer.setSurName(dtoCustomer.getSurName());
        tCustomer.setDni(dtoCustomer.getDni());
        tCustomer.setPhone(dtoCustomer.getPhone());
        tCustomer.setGender(dtoCustomer.getGender());
        tCustomer.setState(dtoCustomer.getState());
        tCustomer.setCreatedAt(dtoCustomer.getCreatedAt());
        tCustomer.setUpdatedAt(dtoCustomer.getUpdatedAt());

        customerRepository.save(tCustomer);

        return true;        
    }

    public List<CustomerDTO> getAllCustomers(){
        List<TCustomer> listTCustomer= customerRepository.findAll();

		List<CustomerDTO> listDtoCustomer = new ArrayList<>();

		for (TCustomer tCustomer : listTCustomer) {
			CustomerDTO dtoCustomer = new CustomerDTO();

			dtoCustomer.setIdCustomer(tCustomer.getIdCustomer());
            dtoCustomer.setFirstName(tCustomer.getFirstName());
            dtoCustomer.setSurName(tCustomer.getSurName());
            dtoCustomer.setDni(tCustomer.getDni());
            dtoCustomer.setPhone(tCustomer.getPhone());
            dtoCustomer.setGender(tCustomer.getGender());
            dtoCustomer.setState(tCustomer.getState());
            dtoCustomer.setCreatedAt(tCustomer.getCreatedAt());
            dtoCustomer.setUpdatedAt(tCustomer.getUpdatedAt());

			listDtoCustomer.add(dtoCustomer);
		}
		
		return listDtoCustomer;
    }
   
    @Transactional
    public boolean deleteCustomer(String idCustomer){
        customerRepository.deleteById(idCustomer);
        return true;
    }

    @Transactional
    public boolean updateCustomer(CustomerDTO dtoCustomer){
        dtoCustomer.setUpdatedAt(new Date());

        Optional<TCustomer> OptionTCustomer = customerRepository.findById(dtoCustomer.getIdCustomer());

        if(!OptionTCustomer.isPresent()){
            return false;
        }
        OptionTCustomer.get().setIdCustomer(dtoCustomer.getIdCustomer());
        OptionTCustomer.get().setFirstName(dtoCustomer.getFirstName());
        OptionTCustomer.get().setSurName(dtoCustomer.getSurName());
        OptionTCustomer.get().setDni(dtoCustomer.getDni());
        OptionTCustomer.get().setPhone(dtoCustomer.getPhone());
        OptionTCustomer.get().setGender(dtoCustomer.getGender());
        OptionTCustomer.get().setState(dtoCustomer.getState());
        OptionTCustomer.get().setUpdatedAt(dtoCustomer.getUpdatedAt());

        customerRepository.save(OptionTCustomer.get());

        return true;
    }
}
