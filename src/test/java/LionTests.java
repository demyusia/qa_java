import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    Feline feline = new Feline();

    @Test
    public void getKittensForLionCallsGetKittensForFeline () throws Exception {
        Lion lion = new Lion(feline, "Самка");
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodForLionCallsGetFoodForFeline() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}
