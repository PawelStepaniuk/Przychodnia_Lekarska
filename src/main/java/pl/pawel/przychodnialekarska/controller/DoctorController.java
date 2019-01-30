package pl.pawel.przychodnialekarska.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pawel.przychodnialekarska.dao.DoctorDao;
import pl.pawel.przychodnialekarska.model.Doctor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class DoctorController {

    @Autowired
    DoctorDao doctorDao;

    //1. TWORZENIE NOWEGO LEKARZA
    @GetMapping("/newdoctor")
    public String newdoctort() {
        return "/newdoctor";
    }


    //2. PRZEKIEROWANIE DO WSZYSTKICH LEKARZY(zapis do bazy danych)
    @PostMapping("/doctors")
    public String savedoctor(@ModelAttribute Doctor doctor, @RequestParam String birthday) {

        doctor.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd")).plusDays(1));

        doctorDao.save(doctor);
        return "redirect:/alldoctors";
    }

    //3. WYŚWIETLENIE WSZYSTKICH LEKRARZY
    @GetMapping("/alldoctors")
    public String alldoctors(ModelMap modelMap) {
        modelMap.put("kluczyk", doctorDao.findAll());
        return "/alldoctors";
    }

}
