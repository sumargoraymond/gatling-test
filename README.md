# gatling-test
Sample gatling load test for Kumparan website

***API Performance/Load testing:***
1. Load testing hit page pilpres
2. Load testing login Kumparan via Google
3. Load testing login Kumparan via Facebook

***How to Run Tests:***
1. `cd` to `bin` folder
2. Run `./gatling.sh -s` and select the preferred scala test to run
For this initial sample it will be:
```
Choose a simulation number:
     [0] LoadTestLoginFB
     [1] LoadTestLoginGoogle
     [2] LoadTestPilpres
 ```
3. Notes: Tests for login FB and Google require currently active token & since it's a security feat from Google & FB, I need to obtain it manually and change when it is already expired.
4. Report will be available under `reports` folder
