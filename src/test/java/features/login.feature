Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initiate the browser with chrome
And Navigate to "http://qaclickacademy.com" site
And Click on Login link in home page to land on Secure sign in Page
When user enters <username> and <password> and logs in
Then Verify that theuser is successfully logged in
And close allbrowsers

Examples:
|username |password |
|test990@gmail.com |123456|
|test999@gmail.com |123456|
