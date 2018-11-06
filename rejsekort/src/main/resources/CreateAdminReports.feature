Feature: Reports generation 
	The manager uses the system to generate relevant reports and statistics. 
				

Scenario: The manager generates a report with statistics of checked-in and checked-out travel cards for all the stations

	Given the manager wants to know the number of travel cards being checked-in and checked-out in all stations

	When he generates a station statistics report 

	Then the system produces a pdf report named as "repStationStatistics.pdf"

Scenario: The manager generates a report with the names of users registered in the system

	Given the manager wants to see a list with the names of users registered in the system

	When he generates a name list 

	Then the system produces a text file named as "repNameList.txt" which contains the name list