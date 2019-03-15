## Flight Reservation Application(REST)

### Endpoints

* User registration
```
-> /flightreservation/user/register
{
    "firstName": "X",
    "lastName": "X",
    "email": "X",
    "password": "X"
}
```
* User Login
```
-> /flightreservation/user/login
Form value -> email, password
```
* Flight Find
```
-> /flightreservation/flight/find
Form value -> from, to, departureDate
```
* Flight Reserve
```
-> /flightreservation/reservation/reserve
Form value -> flightId
```
* Make Reservation
```
-> /flightreservation/reservation/makeReservation
Form value -> flightId, passengerFirstName
     passengerLastName, passengerEmail,
     passengerPhone, others
```
* Find Reservation
```
-> flightreservation/reservation/find/1
```
* Update Reservation
```
-> flightreservation/reservation/update
{
    "id": "X",
    "checkedIn": "X",
    "numberOfBags": "X",
}
```


### Utilities

* Created PdfGenerator Utility.
* Created Email Sender Utility.
* When a reservation is make, an email is sent. 
to the passenger email along with the reservation
pdf.

### Logging

* Created a logging system(logback.xml) in resource folder.


