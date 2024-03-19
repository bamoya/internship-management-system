package com.ecm.internManagementApp.service;

import com.ecm.internManagementApp.exception.PromoNotFoundException;
import com.ecm.internManagementApp.model.entities.Promo;
import com.ecm.internManagementApp.repository.PromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoService {

    @Autowired
    private PromoRepository promoRepository;

    public boolean existsById(Long id){
        return promoRepository.existsById(id);
    }
    public boolean exitsByYear(int year){
        return promoRepository.existsByPromoYear(year);
    }
    public List<Promo> getAllPromos(){
        return promoRepository.findAll();
    }

    public Promo getPromoById(Long id){
        return promoRepository.findById(id)
                .orElseThrow(()-> new PromoNotFoundException("promo by id "+id+" wasn't found."));
    }

    public Promo getPromoByYear(int year){
        return promoRepository.findByPromoYear(year)
                .orElseThrow(() -> new PromoNotFoundException(String.format("promo by year %d wasn't found,", year)));
    }

    public Promo savePromo(Promo promo){
        return promoRepository.save(promo);
    }

    public List<Promo> saveListOfPromos(List<Promo> promos){
        return promoRepository.saveAll(promos);
    }

    public Promo updatePromo(Long id, Promo promo){
        if (promoRepository.existsById(id)){
            return promoRepository.save(promo);
        }
        throw new PromoNotFoundException("promo with id "+id+" not found");
    }

//    public Promo partialUpdate(Long id, Promo promo){
//        if (!promoRepository.existsById(id)){
//            throw new PromoNotFoundException("promo with id "+id+" not found");
//        }
//        Optional<Promo> promoToUpdate = promoRepository.findById(id);
//
//    }

    public void deletePromo(Long id){
        promoRepository.deleteById(id);
    }



}
