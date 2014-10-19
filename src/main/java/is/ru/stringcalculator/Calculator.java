package is.ru.stringcalculator;

import java.util.regex.*;

public class Calculator {

	public static int add(String text) throws Calculator.NegativeException{
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")||text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) throws Calculator.NegativeException{
		if(numbers.contains("//")){
		Pattern pattern = Pattern.compile("//(.)\n(.+)");
		Matcher match = pattern.matcher(numbers);

			if(match.matches()){
				String delimeter = match.group(1);
				String newNumbers = match.group(2);
				return newNumbers.split(",|\n|" + delimeter);
			}
		}
		return numbers.split(",|\n");
	}

   	private static int sum(String[] numbers) throws Calculator.NegativeException{
 	   	int total = 0;
       		StringBuffer negative = new StringBuffer();
		boolean isNegative = false;
		for(String number : numbers){
			if(number.contains("-")){
				negative.append(number + ",");
				isNegative = true;
			}
			else{
				total += toInt(number);
			}
		}
		if(isNegative){
			String finished = negative.toString();
			throw new NegativeException("Negatives not allowed: " + finished.substring(0, finished.length() - 1));
		}
		else{
			return total;
		}
    	}

	public static class NegativeException extends Exception{
		public NegativeException(){
			super();
		}
		public NegativeException(String message){
			super(message);
		}
	}
}
