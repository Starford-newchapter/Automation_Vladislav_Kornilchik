Automation Project
=====================
Requirements
-----------------------------------
* Java version 11
* Maven
* Selenium + TestNG
* Realization - PageObject pattern
* Using Allure
* Building the project through mvn + testng.xml(there are 4 xml files for execution tests)

Running tests
-----------------------------------
* Clone the project 
```
git clone url
```
* Checkout to the main branch
* Run tests with maven:
  ```
  mvn clean test -Dsuite="src/main/resources/test1.xml
  mvn clean test -Dsuite="src/main/resources/test2.xml
  ```
Driver implementation
-----------------------------------
### Driver is implemented in src/main/java/driver, Listener - src/main/java/testNG/
* BaseTest contains methods setupDriver() and closeDriver(), also BaseTest is connected with Listener
* Listener contains a method for taking screenshots on failed results and a method for allure results
* DriverCreation contains methods getDriver() and quitDriver(), also there is ThreadLocal<WebDriver> driver what help use parallel execution of tests

Allure reports
-----------------------------------
* use this command to generate a report
  ```
  allure generate --clean
  ```
* use this command to open a report
  ```
  allure open
  ```
