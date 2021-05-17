import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    Main mainClass = new Main();

    @Test
    public void WhenInputIsValid_ReturnCompleteList() {
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer[] numbers = {3, 5, 10, 8};

        List<Integer> resultNumbers = mainClass.completeArray(numbers);

        assertEquals(expectedNumbers, resultNumbers);
    }

    @Test
    public void WhenInputIsInvalidNegativeNumber_ReturnNil() {
        Integer[] numbers = {-3, 5, 10, 8};
        List<Integer> expectedEmptyList = new ArrayList<>();

        List<Integer> resultNumbers = mainClass.completeArray(numbers);

        assertEquals(expectedEmptyList, resultNumbers);
        assertEquals(0, resultNumbers.size());
    }

    @Test
    public void WhenInputIsValid_ReturnValidString() {
        String expectedString = "+*DbtB 52";

        String stringResult = mainClass.replaceString("+*CasA 52");

        assertEquals(expectedString, stringResult);
    }

    //asda
    @Test
    public void WhenInputIsValidAndSpecialCaseZ_ReturnValidString() {
        String expectedString = "+*Dbta 52";

        String stringResult = mainClass.replaceString("+*Casz 52");

        assertEquals(expectedString, stringResult);
    }
}
