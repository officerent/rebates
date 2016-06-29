package com.office.rebates.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.rebates.dal.dao.NewRebatesBonusMapper;
import com.office.rebates.model.BonusModel;
import com.office.rebates.model.common.RebatesException;
import com.office.rebates.service.RebatesBonusService;

@Service
public class RebatesBonusServiceImpl implements RebatesBonusService{

	static Logger logger = LoggerFactory.getLogger(RebatesBonusServiceImpl.class);

    @Autowired
    private NewRebatesBonusMapper newRebatesBonusMapper;
    
	@Override
	public List<BonusModel> getRecentBonus() throws RebatesException {
		return newRebatesBonusMapper.getRecentBonusList();
	}



	
	
}
