package se.hw.demo.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import se.hw.demo.calculator.service.CalcService;
import se.hw.demo.calculator.dto.CalcResultDto;

import org.springframework.ui.Model;

@Controller
public class CalculatorWebController {

	@Autowired
	CalcService calcService;

    @RequestMapping(value="/")
	public String home(CalcResultDto dto, Model model) {
		return "list";
	}
    
    @GetMapping(value="/add")
	public String add(CalcResultDto dto, Model model) {
        model.addAttribute("calculation", new CalcResultDto("+"));
		return "calc";
	}
    @GetMapping(value="/subtract")
	public String subtract(CalcResultDto dto, Model model) {
        model.addAttribute("calculation", new CalcResultDto("-"));
		return "calc";
	}
    @GetMapping(value="/multiply")
	public String multiply(CalcResultDto dto, Model model) {
        model.addAttribute("calculation", new CalcResultDto("*"));
		return "calc";
	}
    @GetMapping(value="/divide")
	public String divide(CalcResultDto dto, Model model) {
        model.addAttribute("calculation", new CalcResultDto("/"));
		return "calc";
	}
    
    @PostMapping(value="/calculate")
	public String calculate(CalcResultDto dto, Model model) {
        model.addAttribute("calculation", dto);    	
        calcService.calculate(dto.getA(), dto.getB(), dto.getOperation());
		return "redirect:list";
	}
    
    @GetMapping(value="/list")
	public String list(Model model) {
        model.addAttribute("calculations", calcService.list());
		return "list";
	}

}
