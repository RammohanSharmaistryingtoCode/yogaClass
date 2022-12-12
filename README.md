# Yoga Classes Registration Form
This is an application made for an outsourcing firm that needs to build an admission form for yoga Classes every month.
This application has been made using SpringBoot Java and React Js.
I was given a timespan of two days to build this application as an assignment to submit to FlexMoney to participate in their hiring Challenge.

# Features Implemented:

1. Accepts the user data with all validations implemented <br/>
-> Only people with age limit 18-65 can enroll for the monthly classes.<br/>
-> Payment of monthly fee of 500.<br/>
-> There is a validation done that an old customer has a valid customer id and he can change classes only for future months not current months.</br>
-> All fields need to be filled for admission.<br/>
2. Implemented a seperate backend flow for old and new customers</br>
3. A new customer is given new customer id </br>
4. Old customer is given the option to change the timing for his future class and make a payment for booking any future class.</br>
5. Stores the data provided in the Database. </br> 
The ER diagram of the same has been attached below : </br>
![image](https://user-images.githubusercontent.com/94673160/207119486-c56544b1-dbba-4935-bdb2-b58304e287ca.png)
I have implemented 3 tables </br>
-> for keeping record of the customer.</br>
-> for keeping record of the classes.</br>
-> for the bookings which uses class ID and customer ID , there are scalable in nature as we can add more relevant information that we would
want to have about the customers and classes.</br>
5. Implemented the CompletePayment() which accepts the details of the user and does the payment.<br/>
It also returns the response if the payment has been completed.</br>
6.<br/>
7.<br/>


# Tech Stack:
1. SpringBoot (JAVA) <br/>
SpringBoot is an opensource Java Framework used to create a microservice. It is used to build standalone spring applications
2. Database: PostgreSQL <br/>
I have used the PostgreSQL database in my project. PostgreSQL is a powerful, open source object-relational database system.
3. React <br/>
For the front end of my application I have used react. React is a free and open-source front-end JavaScript library for building user interfaces based on UI components.
4. HTML,CSS<br/>

# Application View
This is the front end of the form that the user sees
![image](https://user-images.githubusercontent.com/94673160/207124734-5f9f97c6-0ff3-4e53-a5bd-78528f25a3fa.png)

This is what happens if the user is of age other than 18-65
![image](https://user-images.githubusercontent.com/88554323/207125851-9461799f-a8d2-4869-87ff-6c20a1f85da8.png)


The error message in case of not all fields being filled
![image](https://user-images.githubusercontent.com/88554323/207126263-9136f283-72a3-4461-9cfe-0c6a677b3c1f.png)

Transaction failed error message
![image](https://user-images.githubusercontent.com/88554323/207127134-f2d5249a-31ee-4c64-92b6-d38af8604818.png)


Success message in case of all user input being valid and the payment being successful
![image](https://user-images.githubusercontent.com/88554323/207126050-8421b896-1f41-40df-aaac-0b248bd10616.png)



# Major Learnings

Perseverance: Encountered bugs that seemed difficult to solve in the first instance to overcoming them felt like victory.
Clearly boosted my confidence and my problem solving skills.
Helped me revise my previously learnt skills.<br/>
Technologies: The project was a fun implementation of SpringBoot and React for me.<br/>
Growth mindset: The project taught me that however big the problem is having a growth mindset helps one overcome any obstacle in the long run.<br/>
