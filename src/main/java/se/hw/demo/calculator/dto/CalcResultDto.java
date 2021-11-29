package se.hw.demo.calculator.dto;

import se.hw.demo.calculator.model.CalcResult;

public class CalcResultDto {

	private String a;
	private String b;
	private String operation;
	private Float result;

	public CalcResultDto() {
	}
	
	public CalcResultDto(String operation) {
		this.operation = operation;
	}
	
	public String  getA() {
		return a;
	}
	public CalcResultDto setA(String a) {
		this.a = a;
		return this;
	}
	public String getB() {
		return b;
	}
	public CalcResultDto setB(String  b) {
		this.b = b;
		return this;
	}
	public String getOperation() {
		return operation;
	}
	public CalcResultDto setOperation(String operation) {
		this.operation = operation;
		return this;
	}
	public Float getResult() {
		return result;
	}
	public CalcResultDto setResult(Float result) {
		this.result = result;
		return this;
	}
	
    public static CalcResultDto model2dto(CalcResult cr) {
    	return new CalcResultDto()
    			.setA(cr.getA())
    			.setB(cr.getB())
    			.setOperation(cr.getOperation())
    			.setResult(cr.getResult());
    }	
    
    public static CalcResultDto create( String a, String b, String operation, Float result) {
    	CalcResultDto calcResult = new CalcResultDto();
    	return calcResult
    			.setA(a)
    			.setB(b)
    			.setOperation(operation)
    			.setResult(result);
    }
}
