
import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParametrize {
    String sex;
    boolean hasMane;

    public LionTestParametrize(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Mock
    Feline feline;
    @Parameterized.Parameters
    public static Object[][] getLionTestParametrize() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test
    public void getCheck() throws Exception {
        Lion lion = new Lion (sex, feline);
        boolean actualCheck = lion.doesHaveMane();
        assertEquals(hasMane, actualCheck);
    }
}