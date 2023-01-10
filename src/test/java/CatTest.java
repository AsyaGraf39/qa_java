import com.example.Cat;
import com.example.Feline;
import org.junit.Test;

import static constants.Constants.CAT_SOUND;
import static org.junit.Assert.assertEquals;

public class CatTest {

    Feline feline;

    @Test
    public void getSoundPositiveTest(){
        Cat cat = new Cat(feline);
        String expected = CAT_SOUND;
        String actual = cat.getSound();
        assertEquals("Ошибка, кот не мяукнул", expected, actual);
    }

}
