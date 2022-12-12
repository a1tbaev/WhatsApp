package Services.Impl;

import Classes.Passport;
import Classes.Profile;
import Enums.Country;
import Services.PersonService;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    List<Passport> passports = new LinkedList<>();
    @Override
    public List<Passport> getAllPassport() {
        return this.passports;
    }

    @Override
    public Passport getPassportByFirstName() {
        String name = new Scanner(System.in).next();
        for (Passport passport : this.passports) {
            if(passport.getFirstName().equals(name)) {
                return passport;
            }
            else {
                System.out.println(name+" is not found!");
            }
        }
        return null;
    }

    @Override
    public void getAllCountries() {
        for (Country value : Country.values()) {
            System.out.println(value);
        }
    }

    @Override
    public void createAPassport() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write the ID: ");
        int id = scanner.nextInt();
        System.out.print("Write the first name: ");
        String firstName = scanner.next();
        System.out.print("Write the last name: ");
        String lastName = scanner.next();
        System.out.print("Write the date of birth: ");
        LocalDate dateOfBirth = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println("where are you from? ");
        Country country = Country.valueOf(scanner.next());
        Passport passport = new Passport(id, firstName, lastName, dateOfBirth,country);
        System.out.println("YOUR PASSPORT IS READY!");
        System.out.println(passport);
        this.passports.add(passport);
    }
}
