package com.capgemini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Leave;
import com.capgemini.Exceptions.ResourceNotFoundException;
import com.capgemini.repository.LeaveRepository;

@Service

public class LeaveserviceImpl implements ILeaveservice{
	@Autowired
	LeaveRepository leaveRep;
	
	@Override
	public Leave addLeave(Leave leave) {
		return leaveRep.save(leave); 
	}

	@Override
	public int removeLeave(int leaveId) throws ResourceNotFoundException {
		Leave toDelete= leaveRep.findById(leaveId).orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id :: " + leaveId));
		if(toDelete!=null){
		leaveRep.deleteById(leaveId);
	}
		return leaveId;
	}
	@Override
	public int update(Integer leaveId,Leave lea) throws ResourceNotFoundException { 
		
		Leave leave=leaveRep.findById(leaveId).orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id :: " + leaveId));
		leave.setStatus(lea.getStatus());
		leave.setFromDate(lea.getFromDate());
		leave.setToDate(lea.getToDate());
		
		 leaveRep.save(leave);
		return leave.getLeaveId();
	}
	
	/*@Override
	public List<Leave> findByEmpId(int empId) {
		//log.info("Found Leaves taken by an employee");
		return leaveRep.findByEmpId(empId);
		
	}*/

	
	

	@Override
	public Leave findLeave(int leaveId) throws ResourceNotFoundException {
		return leaveRep.findById(leaveId).orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id :: " + leaveId));
	}

	@Override
	public List<Leave> findByAllLeaves() {
		
		return leaveRep.findAll();
	}



	}


	


