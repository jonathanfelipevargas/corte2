<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <title>Index</title>
        <link rel="stylesheet" href="resources/css/styles.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1>Ejercicio Criteria</h1>
        <form action="Control" method="post">
            <div>               
            </div>
            <input type="submit" value="Ejecutar" name="Submit" />
        </form>   

        ${datosPunto1}
        <br>
        ${datosPunto2}
        <br>
        ${datosPunto3}
        <br>
        ${datosPunto4}
        <br>

        ${datosPunto5}

        <jsp:include page="footer.jsp"/>

    </body>
</html>