package Classes;

import java.util.Map;

public class WhatsApp {
    private Passport passport;
    private String password;
    private Profile profile;
    private Map<String, String> contacts;

    public WhatsApp(Passport passport, String password, Profile profile) {
        this.passport = passport;
        this.password = password;
        this.profile = profile;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Map<String, String> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, String> contacts) {
        this.contacts = contacts;
    }
}
