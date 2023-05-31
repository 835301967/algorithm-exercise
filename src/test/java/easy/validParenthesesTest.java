package easy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class validParenthesesTest {


    @Test
    void isValid() {
        validParentheses validParentheses = new validParentheses();
        boolean valid = validParentheses.isValid("()");
        assertEquals(true,valid);
        boolean valid1 = validParentheses.isValid("}[]");
        assertEquals(false,valid1);
        boolean valid2 = validParentheses.isValid("}{[]");
        assertEquals(false,valid2);
        boolean valid3 = validParentheses.isValid("({[]})()");
        assertEquals(true,valid3);
    }
    @Test
    void arrayTest(){
        String[] list = new String[10];
        list[9] = "32432";
//        System.out.printf(list[11]);
        System.out.printf(list[9]);
        Arrays.stream(list).filter(l->l!=null).forEach(l-> System.out.println(l));
        int[] ints = new int[10];
        Arrays.stream(ints).forEach(i-> System.out.println(i));
    }
}