package lesson13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckException {

    @Test
    void exception(){

        try {
            System.out.println((char[]) null);
        }
        catch (NullPointerException ex){
            System.out.println("Произошла ошибка - " + ex.getMessage());
            ex.printStackTrace();
        };

        try {
            Assertions.assertTrue(false);
        }
        catch (Error er){
            System.out.println("Произошла ошибка - " + er.getMessage());
            er.printStackTrace();
        };
    }
}
