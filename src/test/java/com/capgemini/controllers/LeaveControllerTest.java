package com.capgemini.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.Leave;
import com.capgemini.services.ILeaveservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;







@WebMvcTest(value = LeaveController.class)
class LeaveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ILeaveservice leaveservice;

	 /* @Test
	  public void testaddLeave() throws Exception{
	  String URI = "/leave/apply";
	  Leave lea=new Leave(); 
	  lea.setFromDate(LocalDate.MIN);
	  lea.setToDate(LocalDate.MAX);
	  lea.setEmployee(new Employee());
	  lea.setStatus("Pending");
	  
		
		  String jsonInput = this.convertToJSON(lea);
		  Mockito.when(leaveservice.addLeave(lea)).thenReturn(
		  lea);
		  MvcResult mvcResult =
		  this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.
		  APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
		  .andReturn();
		  MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		  String jsonOutput = mockHttpServletResponse.getContentAsString();
		  assertThat(jsonOutput).isEqualTo(jsonInput);
		  Assert.assertEquals(HttpStatus.OK.value(),
		  mockHttpServletResponse.getStatus());
	
	  }*/
    
    @Test
    void testaddLeave() throws Exception{
     Leave Lea = new Leave();
   //Lea.setFromDate(null);
     Lea.setStatus("pending");
   // Lea.setToDate(null);
     Mockito.when(leaveservice.addLeave(Mockito.any())).thenReturn(Lea);
		
		

		//Mockito.when(leaveservice.addLeave(Mockito.any())).thenReturn(Lea);
		
		mockMvc.perform(post("/api/v2/create")).contentType(MediaType.APPLICATION_JSON)
		.content(new ObjectMapper().writeValueAsString(Lea))
		.andExpect(MockMvcResultMatchers.status().isCreated());
		
			//	.andExpect(MockMvcResultMatchers.status().isOk());).value("rahul"));
    }
    
    
    
    
    
    
    
    








	@Test
    void testfindLeave() throws Exception{
    	Leave Lea = new Leave();
    	//Lea.setFromDate(null);
		Lea.setStatus("pending");
		//Lea.setToDate(null);
		
	
		Mockito.when(leaveservice.findLeave(Mockito.anyInt())).thenReturn(Lea);
		
		mockMvc.perform(get("/api/v2/99"))
				.andExpect(MockMvcResultMatchers.status().isOk());
    }
 
    
    
	 
    @Test
    void testRemoveLeave() throws Exception{
        String URI = "/{leaveId}";
        Leave lea=new Leave();
        lea.setLeaveId(2);

        Mockito.when(leaveservice.findLeave(2)).thenReturn(lea);
        Mockito.when(leaveservice.removeLeave(2)).thenReturn(-1);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 2)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

       // Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

       
    }
}