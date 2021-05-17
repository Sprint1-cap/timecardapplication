package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.Exceptions.ResourceNotFoundException;
import com.capgemini.entities.Leave;
import com.capgemini.services.ILeaveservice;

	@RestController
	@RequestMapping("/api/v2/")
	public class LeaveController {
		@Autowired
		private ILeaveservice leaveservice;
		
		/*@Autowired
		private EmployeeService empSer;
		
		
		@PostMapping("/apply/{emp_id}")
		public Leave addLeave(@RequestBody Leave leave ,@PathVariable("emp_id") Integer empId ) throws ResourceNotFoundException {
			Employee emp=empSer.getEmpById(empId);
			if(emp!=null) {
				leave.setEmployee(emp); 
				leave.setStatus("Pending");
			}
			return leaveservice.addLeave(leave);
		}*/

		

		
		
		@PostMapping("/create")
		public Leave addLeave(@RequestBody Leave leave) {
			return leaveservice.addLeave(leave);	
		}
		
		
		@GetMapping("/{leaveId}")
		public Leave findLeave(@PathVariable Integer leaveId) throws ResourceNotFoundException{
			return leaveservice.findLeave(leaveId); 
		}
		@GetMapping("/all")
		 List<Leave> findAllLeaves(){
			return leaveservice.findByAllLeaves();
		}
		
		
		@DeleteMapping("/{leaveId}")
		public int removeLeave(@PathVariable Integer leaveId) throws ResourceNotFoundException{
			return leaveservice.removeLeave(leaveId); 
		}
		
		
		@PutMapping("/{leaveId}")
		public int   updateLeave(@RequestBody Leave leave ,@PathVariable Integer leaveId ) throws ResourceNotFoundException {
			return leaveservice.update(leaveId, leave);
		}
		
		
}
