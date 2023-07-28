package aicodepair;

import org.junit.Test;
import static org.junit.Assert.*;

public class CheckIdCardTest {

@Test
public void testValidIdCard() {
    // Test a valid ID card without a check digit
    assertTrue(!CodeWhi.checkIdCard("123456789012345678"));
    
    // Test a valid ID card with a check digit
    assertTrue(!CodeWhi.checkIdCard("12345678901234567X"));
}

    @Test
    public void testInvalidIdCard() {
        assertFalse(CodeWhi.checkIdCard(null));
        assertFalse(CodeWhi.checkIdCard("12345678"));
        assertFalse(CodeWhi.checkIdCard("1234567890123456789"));
        assertFalse(CodeWhi.checkIdCard("123456789012345678Y"));
        assertFalse(CodeWhi.checkIdCard("12345678901234567A"));
    }

}