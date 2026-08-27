import com.example.AlexLion;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTests {

    Feline feline = Mockito.spy(new Feline());
    AlexLion alexLion = new AlexLion(feline);

    public AlexLionTests() throws Exception {
    }

    @Test
    public void isAlexMale () {
        assertTrue(alexLion.doesHaveMane());
    }

    @Test
    public void getKittensForAlexCallsGetKittensWithZero() {
            alexLion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens(0);
     }

    @Test
    public void getFriendsReturnsListOfFriends() {
            List<String> actualFriends = alexLion.getFriends();
            List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман");
            assertTrue(actualFriends.equals(expectedFriends));
    }

    @Test
    public void getPlaceOfLivingIsNewYorkZoo() {
            String placeOfLiving = alexLion.getPlaceOfLiving();
            assertEquals("Нью-Йоркский зоопарк", placeOfLiving);
    }
}
