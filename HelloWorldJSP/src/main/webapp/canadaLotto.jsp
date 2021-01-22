<%--
  Created by IntelliJ IDEA.
  User: user2015
  Date: 1/8/21
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Canada Lottery</title>
</head>
<body>
    <h1>Your Lotto 649 and Lotto MAX winning numbers this draw.</h1>
<%
    // TODO 1: Generate 6 unique random numbers from 1 to 49 sorted ascending (ensure there are no duplicates in the collection)
    //         Print the 6 lottery 649 numbers to the screen.
    //      Hint 1: You can use a Set to store unique values
    //      Hint 2: You can use a TreeSet to sort the a set by natural order
    //      Hint 3: The Random class can be used to generate random numbers

    // TODO 2: Generate 7 unique random numbers from 1 to 50 sorted ascending
    //      Print the 7 lottery MAX numbers to the screen

    // TODO 3: Add a HTML form to the page that allows the user to specify number of quick picks (1 to 10) to generate.
    //  The submit will submit to the same page
    //  Hint 1: To check if the page is access using a post method you can use the following code snippet
    if (request.getMethod().equalsIgnoreCase("post")) {

    }



%>
</body>
</html>
