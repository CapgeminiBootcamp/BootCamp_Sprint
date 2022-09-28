package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Insurance;
import com.capg.exception.EnterValidDetailsException;
import com.capg.exception.InsuranceEmptyException;
import com.capg.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;
	@Override
	public Insurance addInsurance(Insurance insurance) {
		if(insurance.getInsuranceId()<0)
			throw new EnterValidDetailsException("Please Enter valid insuranceId");
		return insuranceRepository.save(insurance);
	}

	@Override
	public Insurance editInsurance(Insurance insurance) {
		if(insurance.getInsuranceId()<0)
			throw new EnterValidDetailsException("Please Enter valid insuranceId");
		return insuranceRepository.save(insurance);
	}

	public Insurance deleteInsurance(int insuranceId) {
		Insurance result=insuranceRepository.findById(insuranceId).get();
		if(result==null)
		  throw new InsuranceEmptyException("Entered Id is not present in database");
		insuranceRepository.deleteById(insuranceId);
		return result;	
			
	}
	
	@Override
	public List<Insurance> getInsurances() {
		List<Insurance> list = insuranceRepository.findAll();
		if (list.isEmpty())
			throw new InsuranceEmptyException("No Insurance Data is present right now");
		return insuranceRepository.findAll();
	}

	@Override
	public Optional<Insurance> findInsuranceByID(int insuranceId) {	
		return insuranceRepository.findById(insuranceId);
	}

}
