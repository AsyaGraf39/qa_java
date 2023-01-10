import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static constants.Constants.FELINE_KIND;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void addLionNegativeTest(){
        Exception exception = null;
        try {
            Lion wrongLion = new Lion("Тюлень", feline);
        } catch (Exception ex){
            exception = ex;
        }
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getKittensLionTest() throws Exception{
        Lion nala = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(4);
        int expected = 4;
        int actual = nala.getKittens();
        assertEquals("Ошибка, неверное количество котят", expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion simba = new Lion("Самец", feline);
        List<String> foodLion = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood(FELINE_KIND)).thenReturn(foodLion);
        List<String> expectedFoodLion = foodLion;
        List<String> actualFoodLion = simba.getFood();
        assertEquals("Ошибка, этим льва не накормить", expectedFoodLion, actualFoodLion);
    }
}
