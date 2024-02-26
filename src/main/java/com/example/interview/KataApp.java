package com.example.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KataApp {


  public static Integer add(String numbers) throws Exception {
//    if(numbers.contains("-")){
//      throw new Exception("Negatives not allowed");
//    }
    if (numbers.length() == 0) {
      return 0;
    }

    return sum(getStringWithNumbers(numbers));
  }


  private static Integer sum(List<Integer> numbers) {
    int sum = 0;
    for (Integer number : numbers) {
      if (number <= 1000) {
        sum += number;
      }
    }
    return sum;
  }

  private static List<Integer> getStringWithNumbers(String numbers) throws Exception {
    List<String> numbersString = List.of(numbers.split(""));
    String lastCharacter = numbersString.get(numbersString.size()-1);
    if(lastCharacter.equals("-") || !isNumericOrMinus(lastCharacter)){
      throw new Exception("Invalid string");
    }

    List<Integer> numbersList = new ArrayList<>();
    String negativeNumbers = "";

    int left = 0;
    while (left < numbersString.size()) {
      if (isNumericOrMinus(numbersString.get(left))) {
        String numberString = numbersString.get(left);
        for (int i = left + 1; i < numbersString.size(); i++) {
          if (isNumericOrMinus(numbersString.get(i))) {
            numberString = numberString.concat(numbersString.get(i));
            left++;
          } else {
            break;
          }
        }
        if (numberString.contains("-")) {
          if (numberString.length() == 0) {
            negativeNumbers = negativeNumbers.concat(numberString + " ");
          } else {
            negativeNumbers = negativeNumbers.concat("," + numberString + " ");
          }

        }
        int number = Integer.parseInt(numberString);
        numbersList.add(number);
      }
      left++;
    }

    if (negativeNumbers.length() > 0) {
      throw new Exception("Negatives not allowed: " + negativeNumbers);
    }
    return numbersList;
  }

  private static boolean isNumericOrMinus(String str) {
    if (Objects.equals(str, "-")) {
      return true;
    }
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
