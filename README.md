# ContractManagerDemo

JAVA TEST

Suppose you are developing a new Java project for a distributor of gas and electricity. This project will handle the costumers and their contracts. 

For the development of this project, you must consider as followed:
●	A contract can be of type gas, electricity, or both (gas and electricity) 
●	Users can have many contracts.
●	A new contract can be made by a private user or business users


Develop one API to insert new contracts.
Develop one API to search contracts with the possibility to search by:
a.	Costumer’s name
b.	Date of start contract.
c.	Type of contract (gas |electricity | gas and electricity)
d.	Type of user (private | business)
All filters can be combined 

Develop one API that retrieves the contracts of one user.
N.B: You have to use Spring Boot e JPA/Hibernate

TEST SOLUTION
Per la soluzione del problema dato sono stati usate le seguenti tecnologie:
1.	DataBase: PostgreSql.
2.	Spring Boot
3.	IDE: Eclipse
4.	PostMan per testare le chiamate rest(in allegato troverete la collection)
Usato CommandLineRunner per l’inserimento di:
1.	Type of contract (gas |electricity | gas and electricity)
2.	Type of user (private | business)
Usato file application.properties per stabilere la connesione al DB ,inserite variabili per le tariffe del gas dell'elettricità.
Implementati 4 metodi con filtri combinati.
