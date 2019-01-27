package pl.pawel.przychodnialekarska.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.pawel.przychodnialekarska.dao.PatientDao;
import pl.pawel.przychodnialekarska.model.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class PatientController {

    @Autowired
    PatientDao patientDao;

    //1. TWORZENIE NOWEGO PACJENTA
    @GetMapping("/newpatient")
    public String newpatient() {
        return "/przychodnia/newpatient";
    }

    //2. ZAPIS W BAZIE DANYCH ORAZ PRZEKIEROWANIE
    @PostMapping("/patients")
    public String savepatient(@RequestParam String birthday, @ModelAttribute Patient patient) {
        patient.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd")).plusDays(1));
        patientDao.save(patient);
        return "redirect:/allpatients";
    }
    //3. WYŚWIETLENIE WSZYSTKICH PACJENTÓW
    @GetMapping("/allpatients")
    public String allpatients(ModelMap modelMap) {
        modelMap.put("patients", patientDao.findAll());
        return "/przychodnia/allpatients";
    }





}
