package com.ecm.internManagementApp.controller;

import com.ecm.internManagementApp.model.entities.Promo;
import com.ecm.internManagementApp.model.entities.Teacher;
import com.ecm.internManagementApp.service.PromoService;
import com.ecm.internManagementApp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/promo")
public class PromoController {
    @Autowired
    private PromoService promoService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<?> getAllPromos(@RequestParam(required = false) Integer year) {
        if (year != null){
            try {
                return new ResponseEntity<>(
                        promoService.getPromoByYear(year),
                        HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(
                        String.format("Promo by year %d not found",year),
                        HttpStatus.NOT_FOUND
                );
            }
        }
        return new ResponseEntity<>(promoService.getAllPromos(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPromoById(@PathVariable Long id) {
        if (!promoService.existsById(id)){
            return new ResponseEntity<>(
                    String.format("Promo by id %d not found", id),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(promoService.getPromoById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> savePromo(@RequestBody Promo promoData) {
        if (promoService.exitsByYear(promoData.getPromoYear())){
            return new ResponseEntity<>(
                    String.format("Promo of year %d already exists.",promoData.getPromoYear()),
                    HttpStatus.BAD_REQUEST);
        }
        if (promoData.getTeacherDirector() != null){
            try {
                teacherService.isExists(promoData.getTeacherDirector().getId());
                Teacher teacher = teacherService.getTeacherById(promoData.getTeacherDirector().getId()) ;
                promoData.setTeacherDirector(teacher);
            }
            catch (Exception e){
                return new ResponseEntity<>("Teacher not found",HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(promoService.savePromo(promoData), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<Promo>> saveListOfPromos(@RequestBody List<Promo> promos) {
        return new ResponseEntity<>(promoService.saveListOfPromos(promos), HttpStatus.CREATED);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Promo> updatePromo(@PathVariable Long id, @RequestBody Promo promo) {
//        Promo promoToUpdate= promoService.getPromoById(id);
//        if (promoService.){
//            return ResponseEntity.notFound().build();
//        }
//
//        return new ResponseEntity<>(promoService    (id, promo), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePromo(@PathVariable Long id) {
        if (!promoService.existsById(id)){
            new ResponseEntity<>(
                    String.format("Promo by id %d not found.",id),
                    HttpStatus.NOT_FOUND);
        }
        promoService.deletePromo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

