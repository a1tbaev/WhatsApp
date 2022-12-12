package Services;

import Classes.Profile;
import Enums.Status;
import Services.Impl.PersonServiceImpl;

import java.util.List;
import java.util.Queue;

public interface WhatsAppService {
    List<Profile>getAllWhatsApp();
    Profile yourProfile();
    void allStatus();
    String installWhatsApp(PersonServiceImpl personService);
    String changeStatus();
    String addContact();
    String sendMessage();
    Queue<String> seeMassage();
    Status seeStatus();
}
