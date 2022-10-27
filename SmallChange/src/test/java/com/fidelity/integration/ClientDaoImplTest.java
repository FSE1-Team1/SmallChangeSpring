/*
 * package com.fidelity.integration;
 * 
 * import static org.junit.jupiter.api.Assertions.*;
 * 
 * import java.time.LocalDate; import java.util.ArrayList; import
 * java.util.List;
 * 
 * import org.junit.jupiter.api.AfterEach; import
 * org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * 
 * import com.fidelity.model.Client; import
 * com.fidelity.model.ClientIdentification;
 * 
 * class ClientDaoImplTest {
 * 
 * SimpleDataSource dataSource; TransactionManager transactionManager;
 * ClientDaoImpl clientDao;
 * 
 * Client client1 = new Client("ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515", "Akila",
 * "R", LocalDate.of(2001, 03, 03), "akilayrs@gmail.com", "Testing123*", "IN",
 * "18181818", new ClientIdentification("Passport", "1820192019")); Client
 * client2 = new Client("c7cb85bf-c6df-4d43-a23c-d3b0ddd4743b", "Pavithra", "B",
 * LocalDate.of(2000, 01, 01), "pavithrab@gmail.com", "Testing123*", "IN",
 * "18000000", new ClientIdentification("Passport", "18000000"));
 * 
 * @BeforeEach void setUp() throws Exception { dataSource = new
 * SimpleDataSource(); clientDao = new ClientDaoImpl(dataSource);
 * transactionManager = new TransactionManager(dataSource);
 * transactionManager.startTransaction(); }
 * 
 * @AfterEach void tearDown() throws Exception {
 * transactionManager.rollbackTransaction(); dataSource.shutdown(); clientDao =
 * null; }
 * 
 * @Test void test_daoObjectCreation_NotNull() { assertNotNull(clientDao); }
 * 
 * // positive tests
 * 
 * // @Test // void test_getAllClients_success() { // List<Client> clients = new
 * ArrayList<Client>(); // clients = clientDao.getAllClients(); //
 * assertEquals(1, clients.size(), "Should contain 1 client"); //
 * assertTrue(clients.contains(client1)); // }
 * 
 * // @Test // void test_insertClient_success() { //
 * clientDao.insertClient(client2); // List<Client> clients = new
 * ArrayList<Client>(); // clients = clientDao.getAllClients(); //
 * assertEquals(2, clients.size(), "Should contain 2 clients"); //
 * assertTrue(clients.contains(client2)); // }
 * 
 * // @Test // void test_deleteClient_success() { //
 * clientDao.deleteClient("c7cb85bf-c6df-4d43-a23c-d3b0ddd4743b"); //
 * List<Client> clients = new ArrayList<Client>(); // clients =
 * clientDao.getAllClients(); // assertEquals(1, clients.size(),
 * "Should contain 1 client"); // assertFalse(clients.contains(client2)); // }
 * 
 * // negative tests
 * 
 * @Test void test_insertNullClient_throwsException() {
 * assertThrows(NullPointerException.class, () -> {
 * clientDao.insertClient(null); }); }
 * 
 * @Test void test_insertDuplicateClient_throwsException() {
 * assertThrows(DatabaseException.class, () -> {
 * clientDao.insertClient(client1); }); }
 * 
 * }
 */