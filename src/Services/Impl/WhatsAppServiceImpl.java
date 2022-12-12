package Services.Impl;

import Classes.Passport;
import Classes.Profile;
import Classes.WhatsApp;
import Enums.Status;
import Services.WhatsAppService;

import java.util.*;

public class WhatsAppServiceImpl implements WhatsAppService {
    List<WhatsApp> whatsApps = new LinkedList<>();
    Queue<String> sendMassages = new LinkedList<>();
    @Override
    public List<Profile> getAllWhatsApp() {
        List<Profile> profiles = new LinkedList<>();
        for (WhatsApp whatsApp : whatsApps) {
            profiles.add(whatsApp.getProfile());
        }
        return profiles;
    }

    @Override
    public Profile yourProfile() {
        String password = new Scanner(System.in).next();
        for (WhatsApp whatsApp : whatsApps) {
            if (whatsApp.getPassword().equals(password)) {
                return whatsApp.getProfile();
            }
        }
        return null;
    }

    @Override
    public void allStatus() {
        for (Status value : Status.values()) {
            System.out.println(value);
        }
    }

    @Override
    public String installWhatsApp(PersonServiceImpl personService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("your ID:");
        int id = scanner.nextInt();
        for (Passport passport : personService.getAllPassport()) {
            if (passport.getId() == id) {
                System.out.println("successfully installed!");
                System.out.print("phone number: ");
                String phoneNum = scanner.next();
                System.out.print("userName: ");
                String userName = scanner.next();
                System.out.print("write password: ");
                String password = scanner.next();
                Profile profile = new Profile(phoneNum, Status.HELLO_I_AM_USING_WHATSAPP, "default image", userName);
                WhatsApp whatsApp = new WhatsApp(passport, password, profile);
                this.whatsApps.add(whatsApp);
                System.out.println(profile);
                return "~~~~~~~~~~~~~~~~~~~~~~~~~";
            }
        }
        return "your id is not found!";
    }

    @Override
    public String changeStatus() {
        System.out.print("password: ");
        String password = new Scanner(System.in).next();
        for (WhatsApp whatsApp : whatsApps) {
            if (whatsApp.getPassword().equals(password)) {
                System.out.println("new Status");
                whatsApp.getProfile().setStatus(Status.valueOf(new Scanner(System.in).next()));
                return "Status successfully changed!";
            }
        }
        return "Status did not change !!";
    }

    @Override
    public String addContact() {
        System.out.print("Write the password: ");
        String password = new Scanner(System.in).next();
        System.out.print("Write the phone number: ");
        String phoneNumber = new Scanner(System.in).next();
        for (WhatsApp whatsApp : whatsApps) {
            if(whatsApp.getPassword().equals(password)){
                for (WhatsApp app : whatsApps) {
                    if(app.getProfile().getPhoneNumber().equals(phoneNumber))
                        whatsApp.getContacts().put(app.getProfile().getPhoneNumber(), app.getProfile().getUserName());
                    return "Person is successfully added!";
                }
            }
        }
        return "Wrong password!";
    }

    @Override
    public String sendMessage() {

        System.out.print("Write your password: ");
        String password = new Scanner(System.in).next();
        System.out.print("who do you want to write?");
        String userName = new Scanner(System.in).next();
        boolean correct = true;
        for (WhatsApp whatsApp : whatsApps) {
            if(whatsApp.getPassword().equals(password)){
                while (correct){
                    String massage = new Scanner(System.in).next();
                    if (massage.equals("SEND")){
                        correct = false;
                        return "massage successfully sent!";
                    }else {
                        this.sendMassages.add(whatsApp.getProfile().getUserName() +": " + massage);
                    }
                }
            }
        }
        return "";
    }

    @Override
    public Queue<String> seeMassage() {
        return this.sendMassages;
    }

    @Override
    public Status seeStatus() {
        String userName = new Scanner(System.in).next();
        for (WhatsApp whatsApp : whatsApps) {
            if (whatsApp.getProfile().getUserName().equals(userName)) {
                return whatsApp.getProfile().getStatus();
            }
        }
        return null;
    }
}
