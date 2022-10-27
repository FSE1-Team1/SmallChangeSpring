package com.fidelity.integration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;


public class ClientDaoImpl implements ClientDao {
	
	protected DataSource dataSource;

	public ClientDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	private final String getAllClients = """
			SELECT c."client_id", c."first_name", c."last_name", c."dob", c."email", c."password", c."country", c."postal_code", ci."type", ci."value"
			FROM sc_client c, sc_client_identification ci
			WHERE c."client_id" = ci."client_id"
			ORDER BY c."first_name"
		""";
	
	private final String insertClient = """
			INSERT
			INTO sc_client ("client_id", "first_name", "last_name", "dob", "email", "password", "country", "postal_code")
			VALUES (?, ?, ?, ?, ?, ?, ?, ?)
		""";
	
	private final String insertClientIdentification = """
			INSERT
			INTO sc_client_identification ("client_id", "type", "value")
			VALUES (?, ?, ?)
		""";
	
	private final String updateClient = """
			
			
		""";
	
	private final String deleteClient = """
			DELETE 
			FROM sc_client
			WHERE "client_id" = ?
		""";
	
	private final String deleteClientIdentification = """
			DELETE 
			FROM sc_client_identification
			WHERE "client_id" = ?
		""";

	@Override
	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<>();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(getAllClients);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				java.sql.Date dbDob = rs.getDate(4);
				LocalDate dob = dbDob.toLocalDate();
				String email = rs.getString(5);
				String password = rs.getString(6);
				String country = rs.getString(7);
				String postalCode = rs.getString(8);
				String type = rs.getString(9);
				String value = rs.getString(10);
				ClientIdentification clientIdentification = new ClientIdentification(type, value);
				Client client = new Client(id, firstName, lastName, dob, email, password, country, postalCode, clientIdentification);
				clients.add(client);
			}
		} catch (SQLException e) {
			throw new DatabaseException("Failed to fetch client details", e);
		}
		return clients;
	}

	@Override
	public void insertClient(Client client) {
		if(client == null) {
			throw new NullPointerException("Client to be inserted cannot be null");
		}
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(insertClient);
			statement.setString(1, client.getId());
			statement.setString(2, client.getFirstName());
			statement.setString(3, client.getLastName());
			statement.setDate(4, Date.valueOf(client.getDateOfBirth()));
			statement.setString(5, client.getEmail());
			statement.setString(6, client.getPassword());
			statement.setString(7, client.getCountry());
			statement.setString(8, client.getPostalCode());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("Failed to insert new client with id = " + client.getId(), e);
		}		
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(insertClientIdentification);
			statement.setString(1, client.getId());
			statement.setString(2, client.getIdentification().getType());
			statement.setString(3, client.getIdentification().getValue());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("Failed to insert client identification details for new with id = " + client.getId(), e);
		}	
		
	}
	
	@Override
	public void updateClient(Client client) {
		/*try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(insertClient);
			statement.setString(1, client.getId());
			statement.setString(2, client.getFirstName());
			statement.setString(3, client.getLastName());
			statement.setDate(4, Date.valueOf(client.getDateOfBirth()));
			statement.setString(5, client.getEmail());
			statement.setString(6, client.getPassword());
			statement.setString(7, client.getCountry());
			statement.setString(8, client.getPostalCode());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("Failed to insert new client with id = " + client.getId(), e);
		}*/
	}

	@Override
	public void deleteClient(String clientId) {
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(deleteClientIdentification);
			statement.setString(1, clientId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("Failed to delete a client with id = " + clientId);
		}
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(deleteClient);
			statement.setString(1, clientId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("Failed to delete client identification details for a client with id = " + clientId);
		}
	}

}
