<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>Spring Boot Market Tracker</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand">U.S. Financial Market Tracker</a>
        <form method="get" action="/get/" class="form-inline">
            <input class="form-control mr-sm-2" type="search" placeholder="Enter Ticker Symbol" aria-label="Search" name="ticker">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>
    <div class="jumbotron">
        <h1 class="display-4">Hello, Interested Nerd!</h1>
        <p class="lead">This app will give you up-to-date market information about a security of your choosing.</p>
        <hr class="my-4">
        <p>Many cool things went into the completion of this fun homework assignment for my advanced Java class.<br>
        Search up top for one of your favorite companies!</p>
    </div>

    <table class="table table-bordered table-dark">
        <tr>
            <th>Ticker Symbol :</th>
            <td><%=request.getParameter("symbol")%></td>
        </tr>
        <tr>
            <th>Company Name :</th>
            <td><%=request.getParameter("description")%></td>
        </tr>
        <tr>
            <th>Last Price :</th>
            <td>$ <%=request.getParameter("last")%></td>
        </tr>
        <tr>
            <th>Days $ Change :</th>
            <td>$ <%=request.getParameter("change")%></td>
        </tr>
        <tr>
            <th>Volume :</th>
            <td><%=request.getParameter("volume")%></td>
        </tr>
        <tr>
            <th>Today's Open :</th>
            <td>$ <%=request.getParameter("open")%></td>
        </tr>
        <tr>
            <th>Today's High :</th>
            <td>$ <%=request.getParameter("high")%></td>
        </tr>
        <tr>
            <th>Today's Low :</th>
            <td>$ <%=request.getParameter("low")%></td>
        </tr>
        <tr>
            <th>Days % Change :</th>
            <td><%=request.getParameter("change_percentage")%> %</td>
        </tr>
        <tr>
            <th>52 Week High :</th>
            <td>$ <%=request.getParameter("week_52_high")%></td>
        </tr>
        <tr>
            <th>52 Week Low :</th>
            <td>$ <%=request.getParameter("week_52_low")%></td>
        </tr>
    </table>
    <a href="#" class="btn btn-dark btn-lg" data-toggle="button" role="button" aria-pressed="false">Load Quote</a>
</div>
</body>
</html>