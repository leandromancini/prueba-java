import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int inserts = 0;

    public void main(String[] args) {
        Integer[] numbers = {3, 5, 100, 8};

        List<Integer> completedList = completeArray(numbers);

        System.out.println(completedList);
        System.out.println(inserts);

        System.out.println(replaceString("+*Casa 52"));

    }

    public List<Integer> completeArray(Integer[] numbers) {
        int actualNumber;
        List<Integer> numberList = new ArrayList<>();
        numberList.addAll(Arrays.asList(numbers));

        int maxNumber = Collections.max(Arrays.asList(numbers));
        int minNumber = Collections.min(Arrays.asList(numbers));

        if (minNumber <= 0) {
            List<Integer> emptyList = new ArrayList<>();
            return emptyList;
        }
        actualNumber = maxNumber - 1;

        for (int i = maxNumber; i > 0; i--) {

            if (!numberList.contains(actualNumber) && actualNumber > 0) {
                numberList.add(actualNumber);
                inserts++;
            }

            actualNumber = actualNumber - 1;
        }

        Collections.sort(numberList);

        return numberList;
    }

    public String replaceString(String string) {
        char[] lowerAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        char[] upperAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        boolean isLowerCase;

        StringBuilder stringBuilder = new StringBuilder(string);
        char alphabetLetter;
        char newLetter;

        for (int i = 0; i < string.length(); i++) {
            char currentLetter = string.charAt(i);

            if (currentLetter == 'z' || currentLetter == 'Z') {

                if (Character.isLowerCase(currentLetter)) {
                    newLetter = 'a';
                    stringBuilder.insert(i, newLetter);
                    stringBuilder.deleteCharAt(i + 1);
                    continue;
                } else {
                    newLetter = 'A';
                    stringBuilder.insert(i, newLetter);
                    stringBuilder.deleteCharAt(i + 1);
                    continue;
                }
            }

            for (int j = 0; j < lowerAlphabet.length; j++) {
                if (Character.isLowerCase(currentLetter)) {
                    alphabetLetter = lowerAlphabet[j];
                    isLowerCase = true;
                } else {
                    alphabetLetter = upperAlphabet[j];
                    isLowerCase = false;
                }
                if (currentLetter == alphabetLetter) {
                    if (isLowerCase) {
                        newLetter = lowerAlphabet[j + 1];
                    } else {
                        newLetter = upperAlphabet[j + 1];
                    }
                    stringBuilder.insert(i, newLetter);
                    stringBuilder.deleteCharAt(i + 1);
                }
            }
        }

        return stringBuilder.toString();
    }

}