package com.fidelity.integration;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fidelity.model.Preferences;

public interface PreferenceMapper {
	
	@Select("""
			select "client_id" as clientId, "investment_purpose" as investmentPurpose, "risk_tolerance" as riskTolerance, "income_category" as incomeCategory, "length_of_investment" as lengthOfInvestment from sc_preferences where "client_id" = #{c_id}
			""")
	public Preferences getPreference(@Param("c_id") String c_id);
	
	
	@Insert("""
			INSERT INTO SC_PREFERENCES("client_id", "investment_purpose", "risk_tolerance", "income_category", "length_of_investment") VALUES (#{clientId},#{investmentPurpose}, #{riskTolerance}, #{incomeCategory}, #{lengthOfInvestment})
			""")
	public int insertPreferences(Preferences preference);


	@Update("""
			UPDATE SC_PREFERENCES SET "investment_purpose" = #{investmentPurpose} , "risk_tolerance" = #{riskTolerance} , "income_category" =#{incomeCategory}, "length_of_investment" = #{lengthOfInvestment} where "client_id" = #{clientId}
			""")
	public int updatePreferences(String clientId, String investmentPurpose, String riskTolerance, String incomeCategory, String lengthOfInvestment);

	@Delete("""
			DELETE FROM SC_PREFERENCES WHERE "client_id" = #{clientId}
			""")
	public int deletePreferences(@Param("clientId") String clientId);
	
	
}
