package se.hw.demo.calculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import se.hw.demo.calculator.dto.CalcResultDto;
import se.hw.demo.calculator.model.CalcResult;
import se.hw.demo.calculator.repository.CalcRepository;

@Service
public class CalcService {

	@Autowired
	CalcRepository repository;
	
	public CalcResultDto calculate(String a, String b, String operation) {
    	CalcResult probe = new CalcResult();
    	probe.setA(a);
    	probe.setB(b);
    	probe.setOperation(operation);
    	
    	Example<CalcResult> example = Example.of(probe);
		List<CalcResult> results = repository.findAll(example);
		
		if(results == null || results.size() == 0) {   	
	    	Float fa = Float.valueOf(a);
	    	Float fb = Float.valueOf(b);
	    	probe.setA(a);
	    	probe.setB(b);
	    	probe.setOperation(operation);
			switch(operation) {
			case "+": probe.setResult(fa + fb);break;
			case "-": probe.setResult(fa - fb);break;
			case "*": probe.setResult(fa * fb);break;
			case "/": probe.setResult(fa / fb);break;
			default:  probe.setResult(null);
			}	    	
	    	repository.save(probe);
		} else {
			probe = results.get(0);
		}
		
		return CalcResultDto.create(a, b, probe.getOperation(), probe.getResult());
	
	}
	
	public List<CalcResultDto> list()  {
		List<CalcResult> results = repository.findAll();
		List<CalcResultDto> dtos = new ArrayList<>();
		results.stream().forEach(c -> { dtos.add(CalcResultDto.model2dto(c));});
		return dtos;
	}
	
}
