<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sample Detail</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>Sample Detail</h1>
    
    <table>
        <tr>
            <th>Idx</th>
            <td>${selectSample.idx}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${selectSample.name}</td>
        </tr>
        <tr>
            <th>Value</th>
            <td>${selectSample.value}</td>
        </tr>
    </table>
    
    <form id="updateForm">
        <input type="hidden" name="idx" value="${selectSample.idx}"/>
        <label for="name">Name</label>
        <input type="text" name="name" value="${selectSample.name}"/><br/>
        <label for="value">Value</label>
        <input type="text" name="value" value="${selectSample.value}"/><br/>
        <button type="button" onclick="updateSample()">Update</button>
    </form>
    
    <script>
        function updateSample() {
            $.ajax({
                type: "POST",
                url: "<c:url value='/sample/update'/>",
                data: $("#updateForm").serialize(),
                success: function(result) {
                    alert("Success");
                    location.reload();
                },
                error: function(xhr, status, error) {
                    alert("Error: " + error);
                }
            });
        }
    </script>
</body>
</html>