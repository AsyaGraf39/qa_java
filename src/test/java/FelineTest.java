import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static constants.Constants.FAMILY_FELINE;
import static constants.Constants.FELINE_KIND;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatTest() throws Exception{
        List<String> foodPredator = Arrays.asList("Животные", "Птицы", "Рыба");

        Mockito.when(feline.getFood(FELINE_KIND)).thenReturn(foodPredator);
        List<String> expectedFoodFeline = foodPredator;
        List<String> actualFoodFeline = feline.eatMeat();
        assertEquals("Ошибка, этим хищника не накормить", expectedFoodFeline, actualFoodFeline);
    }

    @Test
    public void getFamilyTest(){
        Feline feline = new Feline();
        String expected = FAMILY_FELINE;
        String actual = feline.getFamily();
        assertEquals("Ошибка, это не кошка", expected, actual);
    }

    @Test
    public void getKittensNoArgumentTest(){
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals("Ошибка, неверное количество котят", expected, actual);
    }

    @Test
    public void getKittensWithArgumentTest(){
        int countKittens = 8;
        int expected = countKittens;
        int actual = feline.getKittens(countKittens);
        Mockito.verify(feline, Mockito.times(1)).getKittens(Mockito.anyInt());
        assertEquals("Ошибка, неверное количество котят", expected, actual);
    }

}
