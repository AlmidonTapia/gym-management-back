package com.atapia.main.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atapia.main.dto.TrainerDTO;
import com.atapia.main.entity.TTrainer;
import com.atapia.main.repository.TrainerRepository;

import jakarta.transaction.Transactional;


@Service
public class TrainerService{

    @Autowired
    private TrainerRepository trainerRepository;

    @Transactional
    public  boolean insertTrainer(TrainerDTO dtoTrainer){

        dtoTrainer.setIdTrainer(UUID.randomUUID().toString());
        TTrainer tTrainer = new TTrainer();

        tTrainer.setIdTrainer(dtoTrainer.getIdTrainer());

        tTrainer.setFirstName(dtoTrainer.getFirstName());
        tTrainer.setSurName(dtoTrainer.getSurName());
        tTrainer.setDni(dtoTrainer.getDni());
        tTrainer.setSpecialization(dtoTrainer.getSpecialization());
        tTrainer.setPhone(dtoTrainer.getPhone());
        tTrainer.setState(dtoTrainer.getState());   
        tTrainer.setCreatedAt(dtoTrainer.getCreatedAt());
        tTrainer.setUpdatedAt(dtoTrainer.getUpdatedAt());

        trainerRepository.save(tTrainer);

        return true;
    }

    public List<TrainerDTO> getAllTrainer(){
        List<TTrainer> listTTrainer = trainerRepository.findAll();

        List<TrainerDTO> listDtoTrainer = new ArrayList<>();

        for (TTrainer tTrainer : listTTrainer) {
            TrainerDTO dtoTrainer = new TrainerDTO();

            dtoTrainer.setIdTrainer(tTrainer.getIdTrainer());
            dtoTrainer.setFirstName(tTrainer.getFirstName());
            dtoTrainer.setSurName(tTrainer.getSurName());
            dtoTrainer.setDni(tTrainer.getDni());
            dtoTrainer.setSpecialization(tTrainer.getSpecialization());
            dtoTrainer.setPhone(tTrainer.getPhone());
            dtoTrainer.setState(tTrainer.getState());
            dtoTrainer.setCreatedAt(tTrainer.getCreatedAt());
            dtoTrainer.setUpdatedAt(tTrainer.getUpdatedAt());

            listDtoTrainer.add(dtoTrainer);
        }

        return listDtoTrainer;
    }

    @Transactional
    public boolean deleteTrainer(String idTrainer){
        trainerRepository.deleteById(idTrainer);
        return true;
    }

    @Transactional
    public boolean trainerUpdate(TrainerDTO dtoTrainer){

        dtoTrainer.setUpdatedAt(new Date());
        Optional<TTrainer> OptionTTrainer = trainerRepository.findById(dtoTrainer.getIdTrainer());

        if(!OptionTTrainer.isPresent()){
            return false;
        }
        OptionTTrainer.get().setFirstName(dtoTrainer.getFirstName());
        OptionTTrainer.get().setSurName(dtoTrainer.getSurName());
        OptionTTrainer.get().setDni(dtoTrainer.getDni());
        OptionTTrainer.get().setSpecialization(dtoTrainer.getSpecialization());
        OptionTTrainer.get().setPhone(dtoTrainer.getPhone());
        OptionTTrainer.get().setState(dtoTrainer.getState());
        OptionTTrainer.get().setCreatedAt(dtoTrainer.getCreatedAt());
        OptionTTrainer.get().setUpdatedAt(dtoTrainer.getUpdatedAt());

        trainerRepository.save(OptionTTrainer.get());

        return true;

    }
}
