package pl.pawel.przychodnialekarska.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // patientId
    // patientID



    private String name;
    private String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String requiredDoctorProfession;
    private long PESEL;

    public Patient(String name, String surname, LocalDate birthday, String requiredDoctorProfession, long PESEL) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.requiredDoctorProfession = requiredDoctorProfession;
        this.PESEL = PESEL;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRequiredDoctorProfession() {
        return requiredDoctorProfession;
    }

    public void setRequiredDoctorProfession(String requiredDoctorProfession) {
        this.requiredDoctorProfession = requiredDoctorProfession;
    }

    public long getPESEL() {
        return PESEL;
    }

    public void setPESEL(long PESEL) {
        this.PESEL = PESEL;
    }


    public String toString(){
        return getName()+" "+getSurname();
    }

}
