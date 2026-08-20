import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
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
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void eatMeatForFelineCallsGetFoodForPredator() throws Exception{
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");

    }
}
