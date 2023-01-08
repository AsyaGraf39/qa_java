import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParameterized {
    private final String sex;
    private final boolean hasMane;
    private Feline feline;


    public LionTestParameterized(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getManeLion(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void addLionPositiveTest() throws Exception{
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals("Ошибка, грива - важная отличительная черта самцов", hasMane, actual);
    }
}
