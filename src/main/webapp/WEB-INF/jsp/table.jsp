<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Spring Boot Market Tracker</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand">U.S. Market Tracker</a>
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
        <p>Heads Up! In case you aren't familiar with ticker symbols, here are a few popular companies you can try:
            <strong>AAPL, TSLA, GOOG, MSFT</strong></p>
    </div>

    <h3>Quotes Table</h3>

    <div class="table-responsive">
        <table class="table table-bordered table-dark">
            <thead>
            <tr>
                <th scope="col">Ticker</th>
                <th scope="col">Company</th>
                <th scope="col">Last Price</th>
                <th scope="col">Day's Change</th>
                <th scope="col">Volume</th>
                <th scope="col">Today's Open</th>
                <th scope="col">Today's High</th>
                <th scope="col">Today's Low</th>
                <th scope="col">Change Percentage</th>
                <th scope="col">52 Week High</th>
                <th scope="col">52 Week Low</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var = "listItem" items = "${quotesList}">
                <tr>
                    <td>${listItem.symbol}</td>
                    <td>${listItem.companyName}</td>
                    <td>${listItem.lastPrice}</td>
                    <td>${listItem.daysChange}</td>
                    <td>${listItem.volume}</td>
                    <td>${listItem.open}</td>
                    <td>${listItem.high}</td>
                    <td>${listItem.low}</td>
                    <td>${listItem.changePercentage}</td>
                    <td>${listItem.fiftyTwoWeekHigh}</td>
                    <td>${listItem.fiftyTwoWeekLow}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="/" class="btn btn-dark btn-lg" role="button" name="load">New Quote</a>
</div>
</body>
</html>