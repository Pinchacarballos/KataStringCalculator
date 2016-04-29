package net.iessanclemente.dapw.katas.stringcalculator;

import net.iessanclemente.dapw.katas.stringcalculator.exception.NegativesNotSupportedException;

public class StringCalculator {

	public int add(String txt) {
		int result = 0;
		switch(txt.length()){
		case 0:
			result = 0;
			break;
		case 1:
			result = Integer.parseInt(txt);
			break;
		default:
			String separators = ",|\n";
			if(txt.startsWith("//")){
				String customSeparator = txt.substring(2,3);
				txt = txt.substring(4);
				separators += "|"+customSeparator;
			}
			String [] numberList = txt.split(separators);
			Integer [] negatives = new Integer[numberList.length];
			int i = 0;
			for(String number : numberList){
				int n = Integer.parseInt(number);
				if(n < 0){
					negatives[i] = n;
					i++;
				}
				result += n;
			}
			if(i != 0){
				throw new NegativesNotSupportedException(negatives);
			}
			break;
		}
		return result;
	}

}
