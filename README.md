# Page Numbers Reducer
## Task
Alice looks through the document and marks pages that she would like to print int the form:
```
1,3,32,5,11,7,6,19,2,21,4,8,22,23
```
Finally, Alice needs to provide page numbers to the pringter in the reduced form:
```
1-8,11,19,21-23,32
```
Please assist Alice with getting reduced form for arbitrary set of page numbers

## Stack of technologies
1. Frameworks: **Spring Boot**

## Deploying project
### First way
 Run SpringBoot application from IntellijIDEA
```
by.milosh.Application
```
### Second way
Copy
```
reducer.war
```
to
```
{tomcat classpath}/webapps
```

## Limitation of solution
1. Use end-points:
```
http://localhost:8080/reducedPageNumbers?rawPageNumbers=<List of numbers>
```
for Tomcat
```
http://localhost:8080/reducer/reducedPageNumbers?rawPageNumbers=<List of numbers>
```
2. List of numbers - String that contain only numbers separeted by commas without spaces
3. Application return response with HTTP Status Code = 400 (Bad Request) with the corresponding message if:
- List of numbers contains other symbols
- List of numbers contains the same numbers in different places
- List of numbers is not assigned (null or empty)