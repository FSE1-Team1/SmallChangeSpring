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
		return mapper.updatePreferences(preference);
	}

	@Override
	public int deletePreference(String clientId) {
		// TODO Auto-generated method stub
		return mapper.deletePreferences(clientId);
	}
	
}
