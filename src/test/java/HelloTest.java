import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    @DisplayName("Test junit 5")
    public void case01(){
        // Arrange = Given
        Hello hello = new Hello();
        // Act = When
        String result = hello.say("nattapol-p");
        // Assert = Then
        assertEquals("Hello nattapol-p",result);
    }

}
