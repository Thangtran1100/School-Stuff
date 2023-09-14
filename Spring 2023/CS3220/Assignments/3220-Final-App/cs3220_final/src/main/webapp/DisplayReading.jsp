<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Reading</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2>${name}'s Readings</h2>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Systolic</th>
                    <th scope="col">Diastolic</th>
                    <th scope="col">Time</th>
                </tr>
            </thead>
            <tbody>
            <form action="DisplayReading" method="POST">
            <input type="hidden" name="userId" value="${selectedUser.id}">
            <input type="text" class="form-control" id="systolicInput" name="systolic">
            <input type="text" class="form-control" id="diastolicInput" name="diastolic">
            <button type="submit" class="btn btn-primary">Add Reading</button>
                <c:forEach items="${readings}" var="reading">
                    <tr>
                        <td>${reading.systolic}</td>
                        <td>${reading.diastolic}</td>
                        <td>${reading.time}</td>
                    </tr>
                </c:forEach>
                </form>
                
                
                <tr>
                    <td>
                        <form action="DisplayReading" method="POST">
                            <input type="hidden" name="userId" value="${selectedUser.id}">
                            <div class="form-group row">
                                <label class="col-form-label" for="systolicInput">Systolic:</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="systolicInput" name="systolic">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-form-label" for="diastolicInput">Diastolic:</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="diastolicInput" name="diastolic">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-2">
                                    <button type="submit" class="btn btn-primary">Add Reading</button>
                                </div>
                            </div>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
