package pl.pawel.przychodnialekarska.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pawel.przychodnialekarska.dao.DoctorDao;
import pl.pawel.przychodnialekarska.dao.PatientDao;
import pl.pawel.przychodnialekarska.dao.VisitDao;
import pl.pawel.przychodnialekarska.model.Visit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Controller
public class VisitController {

    @Autowired
    VisitDao visitDao;
    @Autowired
    PatientDao patientDao;
    @Autowired
    DoctorDao doctorDao;

    //1. TWORZENIE NOWEJ WIZYTY I PRZEKIEROWANIE
    @GetMapping("/newvisit")
    public String newvisit(ModelMap modelMap) {
        modelMap.put("kluczyk1", patientDao.findAll());
        modelMap.put("kluczyk2", doctorDao.findAll());

        return "newvisit";
    }

    //2. PRZEKIEROWANIE
    @PostMapping("/visits")
    public String nowawizyta(@ModelAttribute Visit visit, @RequestParam String date) {
        visit.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).plusDays(1));
        visitDao.save(visit);
        return "redirect:/allvisits";
    }

    //3. WYŚWIETLENIE WSZYSTKICH WIZYT
    @GetMapping("/allvisits")
    public String allvisits(ModelMap modelMap) {
        modelMap.put("kluczyk10", visitDao.findAll());
        return "allvisits";
    }



}
