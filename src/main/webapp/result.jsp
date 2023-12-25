<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        <%@include file="./styles/style-sheet.css" %>
    </style>
</head>
<body>


  <div class="tin-container">
      <h2 class="text-center fw-bold">Result Page :</h2>
      <div class="container mt-5">
          <table class="table table-dark table-hover">
              <thead>
              <tr>
                  <th scope="col">Attributes</th>
                  <th scope="col">Values</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                  <th scope="row">USERNAME</th>
                  <td><%= request.getAttribute("username") %></td>
              </tr>
              <tr>
                  <th scope="row">RESULT</th>
                  <td><%= request.getAttribute("result") %></td>
              </tr>
              <tr>
                  <th scope="row">SCORE</th>
                  <td><%= request.getAttribute("score") %></td>
              </tr>
              <tr>
                  <th scope="row">ATTEMPTS LEFT</th>
                  <td><%= request.getAttribute("attemps") %></td>
              </tr>
              </tbody>
          </table>
      </div>
      <button onclick="window.location.href='index.jsp'" class="btn btn-danger">Go Back to Home</button>
  </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
