package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {


    @Test
    @DisplayName("Exception First name is required")
    public void case01(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class,() ->{
            business.register(null,new Speaker());
        });
        assertEquals("First name is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Exception Last name is required.")
    public void case02(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class,() ->{
            Speaker speaker = new Speaker();
            speaker.setFirstName("nattapol");
            business.register(null,speaker);
        });
        assertEquals("Last name is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Exception Email is required.")
    public void case03(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class,() ->{
            Speaker speaker = new Speaker();
            speaker.setFirstName("nattapol");
            speaker.setLastName("p.");
            business.register(null,speaker);
        });
        assertEquals("Email is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Exception Speaker doesn't meet our standard rules.")
    public void case04(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class,() ->{
            Speaker speaker = new Speaker();
            speaker.setFirstName("nattapol");
            speaker.setLastName("p.");
            speaker.setEmail("nattapol@hotmail.com");
            business.register(null,speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.",exception.getMessage());
    }

    @Test
    @DisplayName("Exception Can't save a speaker.")
    public void case05(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(SaveSpeakerException.class,() ->{
            Speaker speaker = new Speaker();
            speaker.setFirstName("nattapol");
            speaker.setLastName("p.");
            speaker.setEmail("nattapol@gmail.com");
            business.register(null,speaker);
        });
        assertEquals("Can't save a speaker.",exception.getMessage());
    }

    @Test
    @DisplayName("Exception Can't save speaker.")
    public void case06(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(SaveSpeakerException.class,() ->{
            Speaker speaker = new Speaker();
            speaker.setFirstName("nattapol");
            speaker.setLastName("p.");
            speaker.setEmail("nattapol@gmail.com");
            business.register(new SpeakerRepository() {
                @Override
                public Integer saveSpeaker(Speaker speaker) {
                    throw new RuntimeException();
                }
            }, speaker);
        });
        assertEquals("Can't save a speaker.",exception.getMessage());
    }

    @Test
    @DisplayName("save speaker.")
    public void case07(){
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("nattapol");
        speaker.setLastName("p.");
        speaker.setEmail("nattapol@gmail.com");
        int id = business.register(new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 100;
            }
        }, speaker);
        assertEquals(100,id);
    }

}