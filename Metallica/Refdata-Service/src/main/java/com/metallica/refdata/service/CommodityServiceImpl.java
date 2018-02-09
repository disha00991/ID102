package com.metallica.refdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metallica.refdata.model.Commodity;
import com.metallica.refdata.repository.CommodityRepository;

@Service
public class CommodityServiceImpl implements CommodityService{

	@Autowired
	private CommodityRepository commodityRepository;
	
	@Override
	public List<Commodity> findAllCommodity() {
		return commodityRepository.findAll();
	}

}
