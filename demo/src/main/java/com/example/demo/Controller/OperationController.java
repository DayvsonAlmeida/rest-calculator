package com.example.demo.Controller;

import com.example.demo.dto.EquationDTO;
import com.example.demo.Services.OperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class OperationController {
    
    @Autowired
    OperationService service;

  @PostMapping("/sum")
  public ResponseEntity sum(@RequestBody EquationDTO eq) {
    double x = eq.getX();
    double y = eq.getY();
    EquationDTO equation = EquationDTO.builder().x(x).y(y).build();

    try {
      double result = Double.parseDouble(service.sum(equation.getX(), equation.getY()));
      return new ResponseEntity(result, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/sub")
  public ResponseEntity sub(@RequestBody EquationDTO eq) {
    double x = eq.getX();
    double y = eq.getY();
    EquationDTO equation = EquationDTO.builder().x(x).y(y).build();

    try {
      double result = Double.parseDouble(service.sub(equation.getX(), equation.getY()));
      return new ResponseEntity(result, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/mult")
  public ResponseEntity mult(@RequestBody EquationDTO eq) {
    double x = eq.getX();
    double y = eq.getY();
    EquationDTO equation = EquationDTO.builder().x(x).y(y).build();

    try {
      double result = Double.parseDouble(service.mult(equation.getX(), equation.getY()));
      return new ResponseEntity(result, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/div")
  public ResponseEntity div(@RequestBody EquationDTO eq) {
    double x = eq.getX();
    double y = eq.getY();
    EquationDTO equation = EquationDTO.builder().x(x).y(y).build();

    try {
        double result = Double.parseDouble(service.divide(equation.getX(), equation.getY()));
        return new ResponseEntity(result, HttpStatus.OK);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/pow")
  public ResponseEntity pow(@RequestBody EquationDTO eq) {
    double x = eq.getX();
    double y = eq.getY();
    EquationDTO equation = EquationDTO.builder().x(x).y(y).build();

    try {
      double result = Double.parseDouble(service.pow(equation.getX(), equation.getY()));
      return new ResponseEntity(result, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}