package pl.pawel.przychodnialekarska.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@Entity
public class Doctor {


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String name;
    private String surname;
    private String profession;
    private double pricePerHour;

    public Doctor(LocalDate birthday, String name, String surname, String profession, double pricePerHour) {
        this.birthday = birthday;
        this.name = name;
        this.surname = surname;
        this.profession = profession;
        this.pricePerHour = pricePerHour;
    }

    public Doctor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }


    public String toString(){
        return getName()+" "+getSurname();
    }
}
