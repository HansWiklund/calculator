package se.hw.demo.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.hw.demo.calculator.model.CalcResult;

public interface CalcRepository extends JpaRepository<CalcResult, Long>{

}
