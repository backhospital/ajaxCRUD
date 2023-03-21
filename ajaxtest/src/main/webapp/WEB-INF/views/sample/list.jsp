<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sample List</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>Sample List</h1>
	<a href="/sample/insert">작성</a>    
    <table>
        <tr>
            <th>Idx</th>
            <th>Name</th>
            <th>Value</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="selectSampleList" items="${selectSampleList}">
            <tr>
                <td>${selectSampleList.idx}</td>
                <td>${selectSampleList.name}</td>
                <td>${selectSampleList.value}</td>
                <td><a href="<c:url value='/sample/detail?idx=${selectSampleList.idx}'/>">Detail</a></td>
				<td><button onclick="deleteSample(${selectSampleList.idx})">Delete</button></td>                
            </tr>
        </c:forEach>
    </table>
    
    <script>
        function deleteSample(idx) {
            if (confirm("Are you sure?")) {
                $.ajax({
                    type: "POST",
                    url: "<c:url value='/sample/delete'/>",
                    data: {idx: idx},
                    success: function(result) {
                        alert("Success");
                        location.reload();
                    },
                    error: function(xhr, status, error) {
                        alert("Error: " + error);
                    }
                });
            }
        }
    </script>
</body>
</html>