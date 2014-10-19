package is.ru.stringcalculator;

import java.util.regex.*;

public class Calculator {

	public static int add(String text){
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

	private static String[] splitNumbers(String numbers){
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

   	private static int sum(String[] numbers){
 	   	int total = 0;
       		for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    	}

//	public static class NegativeException extends Exception{
//		public NegativeException(){
//			super();
//		}
//		public NegativeException(String message){
//			super(message);
//		}
//	}


}
