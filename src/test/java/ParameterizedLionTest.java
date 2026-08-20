import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTests {
    private Feline feline = new Feline();
    private String sex;
    private boolean expectedHasMane;

    public LionTests(String sex, boolean hasMane) {
        this.sex = sex;
        this.expectedHasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Кто-то", false},
        };
    }

    @Test
    public void checkHasManeForLionTest () {
        try {
            Lion lion = new Lion(feline, sex);
            boolean actualHasMane = lion.doesHaveMane();
            MatcherAssert.assertThat(expectedHasMane, is(actualHasMane));
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }









}
