Test automation framework for Test Case Management Software - TestRail

<a href="https://www.gurock.com/testrail">
<img class="gk-header-sticky-logo-wrapper" src="https://tudip.com/wp-content/uploads/2014/12/blog-images-testrail.jpg" alt="Testrail Logo">
</a>

# Technologies/Libraries

- Java 11
- TestNG 7.1.0
- Maven 3.8.1
- Selenium 3.141.59
- DriverManager 4.4.1
- Allure TestNG 2.13.9
- Allure Maven 2.10.0
- Lombok 1.18.8
- Aspectjweaver 1.9.6
- REST Assured 4.4.0
- Gson 2.8.7
- Jackson 2.12.3
- Javafaker 1.0.2
- Log4j 2.14.1
- CircleCI
- Browser Chrome 90.0
- OS: Windows 10

Tested by: Viktoryia Latosh

Tested on: https://www.gurock.com/testrail/

# Checklist

**Checking of Login**

- Login should be successful. Expected: Home page is opened after login
- The 'Email' field should be required. Expected: Error message
- The 'Password' field should be required. Expected: Error message

**Checking of Project**

- Create new Project. Expected: Project is created and exist on the Projects page.
- Delete the Project. Expected: Project is created, is existed on the Projects page and is deleted.
- Update the Project. Expected: Project data should be updated.
- [REST API] Create new Project. Expected: Response Status 200, response returns valid project data (name).
- [REST API] Delete the Project. Expected: Project is created, is existed on the Projects page and is deleted.

- **Checking of Section**
- [REST API] Create a new Section into the Project. Expected: Response Status 200, response returns valid section data.

- **Checking of Test Case**
- Create new Test Case into the Project. Expected: Test Case is created and exist on the Project details page.
- Delete the Test Case. Expected: Test Case is created, is existed on the Project details page and is deleted.
- [REST API] Create the new Test Case into the Section. Expected: Response Status 200, response returns valid test case
  data (name).
- [REST API] Delete the Test Case. Expected: Test Case is created, is existed on the Project details page and is
  deleted.

- **Checking of Milestone**
- Create a new Milestone into the Project. Expected: Milestone is created and exist on the Project details page.
- Delete the Milestone. Expected: Milestone is created, is existed on the Project details page and is deleted.

- **Checking of Test Run**
- Create a new Test Run into the Project. Expected: Test Run is created and exist on the Project details page.
- Delete the Test Run. Expected: Test Run is created, is existed on the Project details page and is deleted.

Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 119.853 s - in TestSuite
