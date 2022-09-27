package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Insurance;
import com.capg.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;
	@Override
	public Insurance addInsurance(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}

	@Override
	public Insurance editInsurance(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}

	@Override
	public List<Insurance> getInsurances() {
		return insuranceRepository.findAll();
	}

	@Override
	public Optional<Insurance> findInsuranceByID(int insuranceId) {	
		return insuranceRepository.findById(insuranceId);
	}

}
