package com.capg.service;

import java.util.List;
import java.util.Optional;

import com.capg.entity.Customer;
import com.capg.entity.Insurance;

public interface InsuranceService {
	public Insurance addInsurance(Insurance insurance);
	public Insurance editInsurance(Insurance insurance);
	public List<Insurance> getInsurances();
	public Optional<Insurance> findInsuranceByID(int customerId);
	public Insurance deleteInsurance(int insuranceId);
}
