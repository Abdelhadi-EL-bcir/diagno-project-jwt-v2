package com.bezkoder.springjwt.security.services;


import com.bezkoder.springjwt.models.Responce;
import com.bezkoder.springjwt.repository.ResponceRepository;
import com.bezkoder.springjwt.security.services.facades.ResponceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponceServiceImpl implements ResponceService {

    @Autowired
    private ResponceRepository responceRepository;

    @Override
    public Responce create(Responce responce) {
        switch (responce.getText()){
            case "Tout_A_Fait_Daccord" : responce.setNote(5);break;
            case "Daccord" : responce.setNote(4);break;
            case "Neutre" : responce.setNote(3);break;
            case "Pas_daccord" : responce.setNote(2);break;
            case "Desaccord_Total" : responce.setNote(1);break;
            default:break;
        }
        return responceRepository.save(responce);
    }

    @Override
    public Responce update(Responce responce, Long id) {
        if(responceRepository.findById(id) != null){
            Responce resToUpdate = responceRepository.findResponceById(id);
            resToUpdate.setText(responce.getText());
            switch (resToUpdate.getText()){
                case "Tout_A_Fait_Daccord" : resToUpdate.setNote(5);break;
                case "Daccord" : resToUpdate.setNote(4);break;
                case "Neutre" : resToUpdate.setNote(3);break;
                case "Pas_daccord" : resToUpdate.setNote(2);break;
                case "Desaccord_Total" : resToUpdate.setNote(1);break;
                default:break;
            }
            responceRepository.save(resToUpdate);
            return responceRepository.findResponceById(resToUpdate.getId());
        }else{
            return  null;
        }
    }

    @Override
    public String delete(Long id) {
        responceRepository.deleteById(id);
        return "Responce has deleted successfully";
    }

    @Override
    public Responce get(Long id) {
        return responceRepository.findResponceById(id);
    }

    @Override
    public List<Responce> getAll() {
        return responceRepository.findAll();
    }
}
