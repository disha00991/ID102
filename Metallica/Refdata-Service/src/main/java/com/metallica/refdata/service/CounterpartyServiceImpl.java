package com.metallica.refdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metallica.refdata.model.Counterparty;
import com.metallica.refdata.repository.CounterpartyRepository;

@Service
public class CounterpartyServiceImpl implements CounterpartyService{

	@Autowired
	private CounterpartyRepository counterpartyRepository;
	
	@Override
	public List<Counterparty> findAllCounterparty() {
		return counterpartyRepository.findAll();
	}

}
