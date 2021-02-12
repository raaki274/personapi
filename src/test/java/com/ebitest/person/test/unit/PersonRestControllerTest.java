package com.ebitest.person.test.unit;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ebitest.person.rest.controller.PersonRestController;
import com.ebitest.person.rest.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
public class PersonRestControllerTest {
	
    @Autowired
    private MockMvc mvc;
       
    @Test
    public void addPersonAPI() throws Exception 
    {
      Person person = new Person();
      person.setFirst_name("Affu");
      person.setLast_name("Rky");
      person.setAge(35);
      person.setFavourite_colour("Black");
    	mvc.perform(MockMvcRequestBuilders
          .post("/person")
          .content(asJsonString(person))
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isCreated())
          .andExpect(MockMvcResultMatchers.jsonPath("$.first_name").exists())
          .andExpect(MockMvcResultMatchers.jsonPath("$.first_name").value("Affu"));
    }
    
    @Test
    public void updateEmployeeAPI() throws Exception 
    {
    	Person person = new Person();
        person.setFirst_name("RK");
        person.setLast_name("BK");
        person.setAge(36);
        person.setFavourite_colour("Red");
        
        mvc.perform(MockMvcRequestBuilders
          .put("/person")
          .content(asJsonString(person))
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.first_name").value("RK"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.last_name").value("BK"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(36))
          .andExpect(MockMvcResultMatchers.jsonPath("$.favourite_colour").value("Red"));
    }
    
    @Test
    public void getPersonByIdAPI() throws Exception 
    {
      mvc.perform(MockMvcRequestBuilders
          .get("/person/{id}", "RK")
          .accept(MediaType.APPLICATION_JSON))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.first_name").value("RK"));
    }
    
    @Test
    public void deleteEmployeeAPI() throws Exception 
    {
      mvc.perform(MockMvcRequestBuilders.delete("/person/{id}", "Affu"))
            .andExpect(status().isAccepted());
    }
     
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
