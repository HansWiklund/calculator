package se.hw.demo.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import se.hw.demo.calculator.dto.CalcResultDto;
import se.hw.demo.calculator.service.CalcService;

@RestController
@RequestMapping("/api/v1")
public class CalculatorController {
	
	@Autowired
	CalcService calcService;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
       return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"OK\"}");
    }
   
    // ============================================
    // With @PathVariable
    // ============================================
    
    @GetMapping(value="/add/{a}/{b}", produces = "application/json")
	public ResponseEntity<CalcResultDto> add1(@PathVariable String a, @PathVariable String b) {
    	
		return new ResponseEntity<CalcResultDto>(calcService.calculate(a, b, "+"), HttpStatus.OK);
	}
    @GetMapping(value="/subtract/{a}/{b}", produces = "application/json")
	public ResponseEntity<CalcResultDto> subtract1(@PathVariable String a, @PathVariable String b) {
    	
		return new ResponseEntity<CalcResultDto>(calcService.calculate(a, b, "-"), HttpStatus.OK);
	}
    @GetMapping(value="/multiply/{a}/{b}", produces = "application/json")
	public ResponseEntity<CalcResultDto> multiply1(@PathVariable String a, @PathVariable String b) {
    	
		return new ResponseEntity<CalcResultDto>(calcService.calculate(a, b, "*"), HttpStatus.OK);
	}
    @GetMapping(value="/divide/{a}/{b}", produces = "application/json")
	public ResponseEntity<CalcResultDto> divide1(@PathVariable String a, @PathVariable String b) {
    	
		return new ResponseEntity<CalcResultDto>(calcService.calculate(a, b, "/"), HttpStatus.OK);
	}
    
    // ============================================
    // With @RequestParam
    // ============================================
    
    @GetMapping(value="/add", produces = "application/json")
	public ResponseEntity<CalcResultDto> add(@RequestParam String a, @RequestParam String b) {
    	
		return new ResponseEntity<CalcResultDto>(calcService.calculate(a, b, "+"), HttpStatus.OK);
	}
    @GetMapping(value="/subtract", produces = "application/json")
	public ResponseEntity<CalcResultDto> subtract(@RequestParam String a, @RequestParam String b) {
    	
		return new ResponseEntity<CalcResultDto>(calcService.calculate(a, b, "-"), HttpStatus.OK);
	}
    @GetMapping(value="/multiply", produces = "application/json")
	public ResponseEntity<CalcResultDto> multiply(@RequestParam String a, @RequestParam String b) {
    	
		return new ResponseEntity<CalcResultDto>(calcService.calculate(a, b, "*"), HttpStatus.OK);
	}
    @GetMapping(value="/divide", produces = "application/json")
	public ResponseEntity<CalcResultDto> divide(@RequestParam String a, @RequestParam String b) {
    	
		return new ResponseEntity<CalcResultDto>(calcService.calculate(a, b, "/"), HttpStatus.OK);
	}
    
    @GetMapping(value="/list", produces = "application/json")
	public ResponseEntity<List<CalcResultDto>> list() {

		return new ResponseEntity<List<CalcResultDto>>(calcService.list(), HttpStatus.OK);
	}
      

}
