<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/style-sheet.css">
    <style>
        <%@include file="./styles/style-sheet.css" %>
    </style>
    <style>
        .custom-heading {
            color: #ffd60a; /* You can change the color to your preferred color */
        }
    </style>
</head>
<body>

<div class="tin-container">
    <h1 class="text-center fw-bold" >Guess The Number</h1>
    <form  method="post" action="ComputeScore">
        <label for="username"  class=" elements form-label text-white text-center" >Enter Your UserName : </label>
        <input type="text" name="username" id="username" class="form-control  elements text-center" autocomplete="off" autofocus required >
        <label for="userGuess"  class=" elements form-label text-white text-center" >Enter a number between 0-4 : </label>
        <input type="number" maxlength="1" name="userGuess" id="userGuess" class="form-control  elements text-center" autocomplete="off" autofocus required>
        <button type="submit" class="btn btn-success">Submit</button>

</form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>