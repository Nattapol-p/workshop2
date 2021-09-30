import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyRangeTest {

    @Test
    @DisplayName("ทดสอบ case01")
    public  void case01(){
        // Arrange
        String input = "[1,5]";
        MyRange range = new MyRange(input);
        boolean result = range.startWithInClude();
        assertTrue(result,"ต้อง start ด้วย [");
    }

    @Test
    @DisplayName("ทดสอบ case02")
    public  void case02(){
        // Arrange
        String input = "(1,5]";
        MyRange range = new MyRange(input);
        boolean result = range.startWithInClude();
        assertFalse(result,"ต้อง start ด้วย [");
    }

    @Test
    @DisplayName("ทดสอบ case03")
    public  void case03(){
        String input = "[1,5]";
        MyRange range = new MyRange(input);
        int result = range.getStart();
        assertEquals(1,result);
    }

    @Test
    @DisplayName("ทดสอบ case04")
    public  void case04(){
        String input = "[1,2]";
        MyRange range = new MyRange(input);
        boolean result = range.startWith1();
        assertTrue(result," input ตัวที่สองต้องเป็น 1");
    }

    @Test
    @DisplayName("ทดสอบ case05")
    public  void case05(){
        String input = "[2,2]";
        MyRange range = new MyRange(input);
        boolean result = range.startWith1();
        assertFalse(result," input ตัวที่สองต้องเป็น 1");
    }
}
