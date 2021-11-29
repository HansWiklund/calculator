package se.hw.demo.calculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CalcResult {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String a;
	private String b;
	private String operation;
	private Float result;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Float getResult() {
		return result;
	}
	public void setResult(Float f) {
		this.result = f;
	}
	

}
