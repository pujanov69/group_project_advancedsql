## Task 3:

**To be done separately by each sub-group**

Students are supposed to write and run the queries using a spring boot application. The results should match the ones as mentioned in the expected result.

1. Clone the spring boot application provided for this group project.

2. In the DatasourceConfig class inside com.dci.advancedsql.config package, change the database configurations to match with the local settings.

3. In the QueryServiceImpl class inside com.dci.advancedsql.service.impl package, implement all the methods queryOne(), queryTwo()... as per the **[Questions](Questions.md)**.

4. Run corresponding method in the AdvancedsqlApplicationTests class in the com.dci.advancedsql package under the test directory to test and verify the correct implementation of the method.  
    - For example to test the queryOne() method in the QueryServiceImpl, Run the queryOneTest() method as JUnit Test.
        - You can either run a maven command as :  
          - mvn test -Dtest=AdvancedsqlApplicationTests#queryOneTest
        - Or run the queryOneTest method as Junit Test from your IDE.  

5. queryOne() method is implemented as an example and thus students can follow similar way to map the query results to dto and log the results in the console.

Each sub-group has to implement methods for all the 15 **[Questions](Questions.md)**. The methods to be implemented uestions can be divided among individual member of the sub-group as per the question number alternatively. i.e 2, 4, 6, 8... for a member and 3, 5, 7, 9... for other. Or however the division is convenient.
