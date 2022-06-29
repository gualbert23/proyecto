<%-- 
    Document   : login
    Created on : 10 may. 2022, 19:23:25
    Author     : Gualbert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/signin.css" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
     
        <main class="form-signin">
            <form action="LoginControlador" method="POST">
                <img class="mb-4" src="img/youtech.png" alt="" width="300" height="300">
                <h1 class="h3 mb-3 fw-normal">Login</h1>

                <div class="form-floating">
                    <input type="email" name="correo" class="form-control" id="floatingInput" placeholder="nombre@ejemplo.com">
                    <label for="floatingInput">Correo Electronico</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password"  class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Recuerdame
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2022</p>
            </form>
        </main>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
