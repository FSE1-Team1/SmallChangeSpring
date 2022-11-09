package com.fidelity.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fidelity.model.Preferences;

@Repository
@Primary
public class PreferenceDaoImpl implements PreferenceDao {

	
	
	public PreferenceDaoImpl() {
		super();
	}

	@Autowired
	PreferenceMapper mapper;

	@Override
	public Preferences getPreference(String clientId) {
		Preferences pref = mapper.getPreference(clientId);
		System.out.println(pref.toString() + "print object");
		return pref;
	}

	@Override
	public int insertPreference(Preferences preference) {
		
		return  mapper.insertPreferences(preference);
	}

	@Override
	public int updatePreference(Preferences preference) {
		// TODO Auto-generated method stub
		String clientId = preference.getClientId();
		String investmentPurpose = preference.getInvestmentPurpose();
		String riskTolerance = preference.getRiskTolerance();
		String incomeCategory = preference.getIncomeCategory();
		String lengthOfInvestment = preference.getLengthOfInvestment();
		return mapper.updatePreferences(clientId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment);
	}

	@Override
	public int deletePreference(String clientId) {
		// TODO Auto-generated method stub
		return mapper.deletePreferences(clientId);
	}
	
}
