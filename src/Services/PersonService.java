package Services;

import Classes.Passport;

import java.util.List;

public interface PersonService {
        List<Passport> getAllPassport();
        Passport getPassportByFirstName();
        void getAllCountries();
        void createAPassport();

}
