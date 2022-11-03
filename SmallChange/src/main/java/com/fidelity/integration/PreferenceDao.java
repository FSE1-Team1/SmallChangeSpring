package com.fidelity.integration;

import com.fidelity.model.Preferences;

public interface PreferenceDao {

	Preferences getPreference(String clientId);
	int insertPreference(Preferences preference);
	int updatePreference(Preferences preference);
	int deletePreference(String clientId);

	
}
