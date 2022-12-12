import Services.Impl.PersonServiceImpl;
import Services.Impl.WhatsAppServiceImpl;
import Services.WhatsAppService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            PersonServiceImpl personService = new PersonServiceImpl();
            WhatsAppServiceImpl whatsAppService = new WhatsAppServiceImpl();
                    while (true) {
            System.out.println("""
                       >>>>>>>>>>>>> Commands <<<<<<<<<<<<
                       1. Get all countries ->
                       2. Create a passport ->
                       3. Get passport by first name ->
                       4. Get all passport ->
                       5. Go to your profile ->
                       6. Get all status ->
                       7. Install whatsapp ->
                       8. Get all whatsapp ->
                       9. Change status ->
                       10. Add contact ->
                       11. Send a massage ->
                       12. See a status ->
                       13. See massage ->
                    """);
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 1 -> personService.getAllCountries();
                case 2 -> personService.createAPassport();
                case 3 -> System.out.println(personService.getPassportByFirstName());
                case 4 -> System.out.println(personService.getAllPassport());
                case 5 -> System.out.println(whatsAppService.yourProfile());
                case 6 -> whatsAppService.allStatus();
                case 7 -> System.out.println(whatsAppService.installWhatsApp(personService));
                case 8 -> System.out.println(whatsAppService.getAllWhatsApp());
                case 9 -> System.out.println(whatsAppService.changeStatus());
                case 10 -> System.out.println(whatsAppService.addContact());
                case 11 -> System.out.println(whatsAppService.sendMessage());
                case 12 -> System.out.println(whatsAppService.seeStatus());
                case 13 -> {
                    for (String s : whatsAppService.seeMassage()) {
                        System.out.println(s);
                    }
                }
            }
        }
    }
}