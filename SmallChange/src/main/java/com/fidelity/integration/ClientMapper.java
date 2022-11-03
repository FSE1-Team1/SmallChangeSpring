package com.fidelity.integration;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;

public interface ClientMapper {
	@Results({
			@Result(property = "id", column = "client_id", id = true),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"),
			@Result(property = "dateOfBirth", column = "dob"),
			@Result(property = "email", column = "email"),
			@Result(property = "password", column = "password"),
			@Result(property = "country", column = "country"),
			@Result(property = "postalCode", column = "postal_code"),
			@Result(property = "identification", column = "client_id", one = @One(select = "com.fidelity.integration.ClientMapper.getClientIdentification"))
	})
	@Select("""
				SELECT c."client_id", c."first_name", c."last_name", c."dob", c."email", c."password", c."country", c."postal_code"
				FROM sc_client c
				ORDER BY c."first_name"
			""")
	public List<Client> getAllClients();
	
	@Results({
			@Result(property = "id", column = "client_id", id = true),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"),
			@Result(property = "dateOfBirth", column = "dob"),
			@Result(property = "email", column = "email"),
			@Result(property = "password", column = "password"),
			@Result(property = "country", column = "country"),
			@Result(property = "postalCode", column = "postal_code"),
			@Result(property = "identification", column = "client_id", one = @One(select = "com.fidelity.integration.ClientMapper.getClientIdentification"))
	})
	@Select("""
				SELECT c."client_id", c."first_name", c."last_name", c."dob", c."email", c."password", c."country", c."postal_code"
				FROM sc_client c
				WHERE c."email" = #{value}
			""")
	public Client getClientByEmail(String email);
	
	@Results({
		@Result(property = "id", column = "client_id", id = true),
		@Result(property = "type", column = "type"),
		@Result(property = "value", column = "value")
	})
	@Select("""
				SELECT ci."client_id", ci."type", ci."value" 
				FROM sc_client_identification ci
				WHERE ci."client_id" = #{value}
			""")
	public ClientIdentification getClientIdentification(String id);
	
	@Insert("""
				INSERT
				INTO sc_client ("client_id", "first_name", "last_name", "dob", "email", "password", "country", "postal_code")
				VALUES (#{id}, #{firstName}, #{lastName}, #{dateOfBirth}, #{email}, #{password}, #{country}, #{postalCode})
			""")
	public int insertClient(Client client);
	
	@Insert("""
				INSERT
				INTO sc_client_identification ("client_id", "type", "value")
				VALUES (#{id}, #{type}, #{value})
			""")
	public int insertClientIdentification(ClientIdentification identification);
	
	@Delete("""
				DELETE 
				FROM sc_client_identification
				WHERE "client_id" = #{id}
			""")
	public int deleteClientIdentification(String id);
	
	@Delete("""
				DELETE 
				FROM sc_client
				WHERE "client_id" = #{id}
			""")
	public int deleteClient(String id);
}
