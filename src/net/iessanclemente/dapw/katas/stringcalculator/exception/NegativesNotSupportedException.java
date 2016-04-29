package net.iessanclemente.dapw.katas.stringcalculator.exception;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NegativesNotSupportedException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;
	private Integer[] negatives;
	
	public NegativesNotSupportedException(Integer[] negatives) {
		super("Negativos no soportados"+String.join(", ", (String[]) Arrays.asList(negatives).stream().map(new Function<Integer, String>(){
			@Override
			public String apply(Integer arg) {
				// TODO Auto-generated method stub
				return ""+arg;
			}
		}).collect(Collectors.toList()).toArray(new String[negatives.length])));
		this.negatives = negatives;
	}
	
	public Integer[] getNegatives() {
		return negatives;
	}
	
}
