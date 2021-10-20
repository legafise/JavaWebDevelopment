<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%request.setAttribute("cssPath", request.getContextPath() + "/static/css/style.css");%>
<%request.setAttribute("mainPageURL", request.getContextPath() + "/controller?command=main_page");%>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="${cssPath}">

        <title>XML Parser</title>
    </head>
    <body>
        <header>
            <div class="container-fluid main-page-link">
                <a href="${mainPageURL}">
                    <h1>Main page</h1>
                </a>
            </div>
            <br/>
        </header>