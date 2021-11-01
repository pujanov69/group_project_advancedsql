## Task 1:

**To be done individually by each member of the group**

Setting up new database for the group project.

We will use a new database. Every group member needs to set up a database in their machine following the instructions provided.


Let's restore the database!
- Download the group-project.tar file provided.


Hop over to pgAdmin:
- Connect to PostgreSQL server.
- From the left nav :
  - go to Servers -> PostgreSQL -> Right click on Databases -> Create -> Database
  - give name to this database as group-project and save
  - On the drop down menu -> click on group-project so we can connect to it.
  - Then right click on group-project and select restore
	- On the Restore modal (In General tab): 	
		- Format : Custom or tar
		- Filename : Give full path to the downloaded tar file. (group-project.tar)
			(Either manually type the full path or select using the three horizontal dots button.)
			(Hint: Change Format to All Files instead of backup in the Select file modal)
	- On the Restore modal, switch to Restore options tab:
		- Inside Sections toggle the Pre-data, Data and Post-data to yes leaving all others as default and click on Restore.
<br><br>       
- Go ahead right click on the group-project databse and Refresh

- Inside group-project --> Go to schemas -->
	- You'll notice there are two schemas :
		- public and cd
	- The cd schema is actually the one we are using.

  - This means the queries for the FROM tables will have cd. in front of them., for example :
      	- SELECT * FROM cd.bookings
      	- SELECT * FROM cd.facilities
	- If we expand on the cd schemas Tables, we have 3 tables :
		- bookings
		- facilities &
		- members


- To have an overview of these tables, and our database as a whole using Query tool provided by the pgAdmin
	 - Right click on database group-project and click on Query tool
	 	- For table facilites :
	 		- Inside the query tool, enter and run the query 'SELECT * from cd.facilities'
	 			- we have the following columns :
	 				- facid -> faclility id
	 				- name -> name of that facility eg: tennis court, gym, massage room etc
	 				- membercost -> how much the facility costs if you're a member
	 				- guestcost -> cost for the facility if you're not a member
	 				- initilaoutlay -> initial outlay paramter
	 				- monthlymaintenance -> how much it'll cost us as the owner of these facilities to run them every month			
	 	- For table members :
	 		- Inside the query tool, enter and run the query 'SELECT * from cd.members'
	 			- we have the following columns :
	 				- memid -> member id
	 				- surname -> member's surname
	 				- firstname -> member's firstname
	 				- address -> member's address
	 				- zipcode -> member's zipcode
	 				- telephone ->	member's telephone
	 				- recommendedby -> who recommended the member to join (could be null)
	 				- joindate -> date the member join
	 	- For table bookings :
	 		- Inside the query tool, enter and run the query 'SELECT * from cd.bookings'
	 			- Bookings essentially holds information about someone or a member booking a facility
	 			- we have the following columns :
	 				- bookingid -> booking id
	 				- facid -> faclility id
	 				- memid -> member id
	 				- starttime -> start time for the booking
	 				- slots ->	how many slots are necessary. if they're playing tennis, they'll book 2 slots. or if they can book only 1 slot if they want to practice with an in-house trainer.


So, our tables contain information about our available facilites, members and members or non-members booking those facilites.												

In this part every individual member created a database and analysed the tables and relationships between them. Moving on we'll use advanced sql queries to obtain data as per the scenarios provided.
