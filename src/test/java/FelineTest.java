import com.example.Feline;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void checkFamilyForFelineIsFeline() {
        String actualFamily = feline.getFamily();
        String expectedFamily = "Кошачьи";
        assertEquals("Должно быть 'Кошачьи'", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensWithArgumentReturnKittensNumber () {
        int expectedKittensNumber = 5;
        int actualKittensNumber = feline.getKittens(expectedKittensNumber);
        assertEquals(expectedKittensNumber, actualKittensNumber);
    }

    @Test
    public void getKittensWithNoArgumentsCallsGetKittensWithOneKitten () {
        int numberOfKittens = feline.getKittens();
        assertEquals(1, numberOfKittens);
    }

    @Test
    public void eatMeatForFelineCallsGetFoodForPredator() throws Exception{
        List<String> food = feline.eatMeat();
        assertEquals(food, List.of("Животные", "Птицы", "Рыба"));
    }
}
