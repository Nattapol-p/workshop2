import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.stream.ImageInputStreamImpl;

import static org.junit.jupiter.api.Assertions.*;

public class MyRangeFailureTest {


    @Test
    @DisplayName("ทดสอบ case1")
    public void case01(){
        try {
            MyRange range = new MyRange("1,5]");
            range.validate();
            fail("ไม่ผิด");
        }catch (InputInvalidException e){
            if(!"Input error".equals(e.getMessage())){
                fail("Error message ผิด" + e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("ทดสอบ case2")
    public void case02(){

        MyRange range = new MyRange("1,5]");
        Exception e = assertThrows(InputInvalidException.class, range::validate);
        assertEquals("Input error",e.getMessage());

    }

}
