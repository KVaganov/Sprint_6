import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;


    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        int expectedKittens = 3;
        Mockito.when(feline.getKittens()).thenReturn(3);
        int actualKittens = lion.getKittens();
        assertEquals("Ожидаемое количество не соответствует фактическому" , expectedKittens, actualKittens);
    }
    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHaveMane = true;
        boolean actualHaveMane = lion.doesHaveMane();
        assertEquals( expectedHaveMane, actualHaveMane);
    }
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFoodLion = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFoodLion);
        List<String> actualFoodLion = lion.getFood();
        assertEquals("Лев ест не ту еду" , expectedFoodLion, actualFoodLion);
    }

    @Test
    public void doesHaveManeExceptionTest()  {
        try{
            Lion lion = new Lion("Не самец", feline);
        } catch (Exception exception){
            String expectedException = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedException, exception.getMessage());
        }
    }

}