package com.capgemini.services;

import java.util.List;

import com.capgemini.Exceptions.ResourceNotFoundException;
import com.capgemini.entities.Leave;

public interface  ILeaveservice {
	public Leave addLeave(Leave leave);

	public Leave findLeave(int leaveId) throws ResourceNotFoundException;

	int removeLeave(int leaveId) throws ResourceNotFoundException;
	
	//List<Leave> findByEmpId(int empId);

	public int update(Integer leaveId, Leave leave) throws ResourceNotFoundException;
	
	List<Leave>findByAllLeaves();



      
}
