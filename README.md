# Smava UI test framework
This is test framework for UI tests for smava.de


##Instructions
### WebDriver
As these tests will be launched on Linux OS, ChromeDriver for Linux is added to src\main\resources directory.
To run tests on Windows OS it is needed to download ChromeDriver for Windows and replace existing driver with new one

### Run Test
To run tests please use "mvn clean verify" command in terminal

### Test Report
To create test report please use "mvn allure:report" command in terminal
Report will be generated to target\site\allure-maven-plugin directory

