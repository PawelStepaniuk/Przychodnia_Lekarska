package pl.pawel.przychodnialekarska.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Id;
import java.time.LocalDate;

@Controller
public class MainController {

    //STRONA GŁÓWNA
    @GetMapping("/")
    public String main(){
        return "/index.html";
    }


}

