mvn versions:display-dependency-updates
[INFO] --- versions-maven-plugin:2.10.0:display-dependency-updates (default-cli) @ Automation_Vladislav_Kornilchik ---
[INFO] artifact io.rest-assured:rest-assured: checking for updates from central
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   io.github.bonigarcia:webdrivermanager ................. 5.0.3 -> 5.1.1
[INFO]   io.qameta.allure:allure-testng ...................... 2.13.9 -> 2.17.3
[INFO]   org.seleniumhq.selenium:selenium-java ................. 4.1.1 -> 4.1.3

mvn clean test  -Dtest=Lecture_19
Results :
Failed tests:
Lecture_19.select_test_1:53 expected [2] but found [4]
Lecture_19.select_test_2:58 expected [3] but found [2]
Tests run: 8, Failures: 2, Errors: 0, Skipped: 0


