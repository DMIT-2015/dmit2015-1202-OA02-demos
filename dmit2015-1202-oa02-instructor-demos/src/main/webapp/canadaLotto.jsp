<%@ page import="java.util.Random" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.TreeSet" %>
<%@ page import="java.util.HashSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- JSTL core library https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/ --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- JSTL formatting library https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/ --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- JSTL functions library https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/ --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--JSP Tag Reference https://docs.oracle.com/cd/E13226_01/workshop/docs81/pdf/files/workshop/JSPTagsReference.pdf  --%>

<!DOCTYPE html>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Lotto 649/MAX Quick Pick Generator</title>

</head>
<body>
<h1>Lotto 649/MAX Quick Pick Generator</h1>
<%
    // Create a Random number generator object
    Random rand = new Random();
    // Create a Set of random number
    Set<Integer> lottery649Set = new TreeSet<>();
    // Generate 6 random numbers for Lottery 649
    final int MAX_LOTTO649_PICKS = 6;
    final int MAX_LOTTO649_VALUE = 49;
    Math.random();
    while (lottery649Set.size() < MAX_LOTTO649_PICKS) {
        // Generate a single number between 1 and 49
        int randomNumber = rand.nextInt(MAX_LOTTO649_VALUE) + 1;
        lottery649Set.add(randomNumber);
    }
    // Iterate through the set and display each number
    out.print("Here are your LOTTO649 quick pick numbers: ");
    for (Integer singleNumber : lottery649Set ) {
        out.print(singleNumber + " ");
    }
    out.println("<br />");

%>


<!-- Optional JavaScript: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>

</body>

</html>