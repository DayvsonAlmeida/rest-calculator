package com.example.demo.ControllerTest;

import javax.ws.rs.core.MediaType;

import com.example.demo.Controller.OperationController;
import com.example.demo.Services.OperationService;
import com.example.demo.dto.EquationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("Teste")
@WebMvcTest(controllers = OperationController.class)
@AutoConfigureMockMvc
public class OperationControllerTest {
  @Autowired
  MockMvc mvc;

  @MockBean   
  OperationService service;

  @Test
  public void shouldSum()throws Exception{
    EquationDTO dto = EquationDTO.builder().x(7).y(3).build();
    String result = "10";

    Mockito.when(service.sum(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

    String json = new ObjectMapper().writeValueAsString(dto);
    
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/sum").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json);
    mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void shouldSub()throws Exception{
    EquationDTO dto = EquationDTO.builder().x(7).y(3).build();
    String result = "4";

    Mockito.when(service.sub(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

    String json = new ObjectMapper().writeValueAsString(dto);
    
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/sub").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json);
    mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void shouldMult()throws Exception{
    EquationDTO dto = EquationDTO.builder().x(7).y(3).build();
    String result = "21";

    Mockito.when(service.mult(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

    String json = new ObjectMapper().writeValueAsString(dto);
    
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/mult").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json);
    mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void shouldDiv()throws Exception{
    EquationDTO dto = EquationDTO.builder().x(6).y(3).build();
    String result = "2";

    Mockito.when(service.deiv(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

    String json = new ObjectMapper().writeValueAsString(dto);
    
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/div").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json);
    mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void shouldExp()throws Exception{
    EquationDTO dto = EquationDTO.builder().x(2).y(3).build();
    String result = "8";

    Mockito.when(service.pow(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

    String json = new ObjectMapper().writeValueAsString(dto);
    
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/pow").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json);
    mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
  }
}