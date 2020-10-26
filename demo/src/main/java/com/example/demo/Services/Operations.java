package com.example.demo.Services;

import org.springframework.stereotype.Service;

@Service
public class Operations {
    
	public String sum(double x, double y) {
    try {        
      return String.valueOf(x + y);
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  public String sub(double x, double y) {
    try {
      return String.valueOf(x - y);   
    } catch (Exception e) {  
      return e.getMessage();
    }
  }

  public String mult(double x, double y) {
    try {
      return String.valueOf(x * y);
    } catch (Exception e) {   
      return e.getMessage();
    }
  }

  public String div(double x, double y) {
    try {
      return String.valueOf(x / y);
    } catch (Exception e) {   
      return e.getMessage();
    }
  }

  public String potencia(double x, double y) {
    try {
      return String.valueOf(Math.pow(x, y)); 
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}