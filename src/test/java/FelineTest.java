import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedMeat = List.of("Животные", "Птицы", "Рыба");
        List<String> actualMeat = feline.eatMeat();
        assertEquals("Кошка ест не ту еду" , expectedMeat, actualMeat);
    }
    @Test
    public void getFamilyTest()  {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Ожидаемое семейство не соответствует фактическому" , expectedFamily, actualFamily);
    }

    @Test
    public void getKittensTest()  {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals("Ожидаемое количество не соответствует фактическому" , expectedKittens, actualKittens);
    }
    @Test
    public void getKittensCountTest()  {
        int kittensCount = 5;
        int actualKittensCount = feline.getKittens(kittensCount);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        assertEquals("Ожидаемое количество не соответствует фактическому" , kittensCount, actualKittensCount);
    }

}
