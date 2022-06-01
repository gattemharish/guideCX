# GuideCX SDET Technical assessment

## Description:
This project contains automated tests that validates below functionalities of GuideCX application
  1. Login: 6 tests
  2. Add team member to Project: 2 tests

The tests are designed using page object pattern, where locator objects and test scripts
are stored seperately like in below screenshot
![image](https://user-images.githubusercontent.com/106559104/171323826-c30342bd-8143-4018-b7c1-141db6bb2f83.png)

## Prerequisites to run the tests
Project and platform Java SDK version should be 1.8
## How to run the tests
1. From Intellij, Once you clone the github repository, you can right click on testng.xml and click on Run
![image](https://user-images.githubusercontent.com/106559104/171324242-a20c0b46-6f7b-4ea0-8824-89e778e93cd2.png)

2. From Command line, just navigate to root of the project and do 
```bash
mvn test
```
## Reports
Report of test execution can be found at target/surefire-reports/index.html

## To-DO
1. There are couple of places where still thread.sleep is used instead of explicit waits.
2. More negative tests can be added to AddTeamMemberPageTest
