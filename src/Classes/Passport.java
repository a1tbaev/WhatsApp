package Classes;

import Enums.Country;

import java.time.LocalDate;

public class Passport {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Country country;

    public Passport(int id, String firstName, String lastName, LocalDate dateOfBirth, Country country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "id=" + id +
                "\nfirstName=" + firstName +
                "\nlastName=" + lastName +
                "\ndateOfBirth=" + dateOfBirth +
                "\ncountry=" + country;
    }
}
