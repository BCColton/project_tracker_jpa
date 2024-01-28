#**Final project API for PromineoTech Back-End boot camp.**

**Author: Brian Colton**

**NOTE: Names for people and locations are based on real world examples, but are purely fictional as they exist in this example data-set.**

##Comments/Questions? Reach out to me!
[LinkedIn](https://www.linkedin.com/in/bccolton/)
[GitHub](https://www.github.com/BCColton/)

##Technology Used

1. 	Java 17		-> Language
2. 	MySQL		-> Database (MySQL WorkBench for administration)
3. 	ARC			-> API Client
4. 	Git/GitHub	-> Version Control
5. 	SpringBoot	-> Application Initialization and Management
6. 	Spring Web	-> REST functionality
7. 	Spring JPA	-> DB Connection and Transaction Management 
8. 	Maven		-> Dependency Management
9. 	Lombok		-> Logging
A. 	Draw.io		-> Entity Relationship Diagram creation	

##Features:

	Create/Post:	
		For project table only at the moment. 
		Use [POST] https://localhost:8080/project/add/name={name}&house={houseId}&budget={budget}&startDate={startDate}
		This inserts a new project into the database with some defaults hard coded into the project.
					
	Read/Get:
		For tables project, employee, and house.	
		Use [Get] https://localhost:8080/{table} to grab all records in a given table.
		Use [Get] https://localhost:8080/{table}/{record_id} to grab a specific record.
	
	Update/Put:
		For project table only at the moment.
		Use [PUT] https://localhost:8080/project/{project_id}/name={value} to update the name of any project currently in the database.
	
	Delete/Delete:
		For project table only at the moment.
		Use [DELETE] https://localhost:8080/project/{project_id} to delete a table that is currently in the database.
		
##What is not included

	The project is not completely container-ized so you will need to
	bring your own JVM/RunTime environment, in addition to your own
	database (the tables will be created and populate at runtime), and
	an API testing client for verbs other than GET. GET requests can be
	handled through https://localhost:8080.


##Known Issues:

	Data: 
		Due to the nature of how I generated my data, you will find that many number combinations 
		do not make sense if you try to map them to a real world setting.
		(I.E. Finding a start date after one or more end dates or budget/bid value mismatches)
		Address are unformatted, or rather formatted as a single String/Text value.
					
	Application:
		Not all tables have functional CRUD URL mappings. 
		Only the name field for a record in the project table can be updated with PUT.
		No error handler has been implemented, so requests made in a browser will be met
		with a default error page.
		
	General:
		All responses are formatted in JSON, so large responses might be difficult to parse.
		The project is severely under-commented.
		It is by no means a pretty project.					