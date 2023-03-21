<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Sample</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function submitForm() {
            $.ajax({
                type: "POST",
                url: "/sample/insert",
                data: $("#sampleForm").serialize(),
                success: function (data) {
                    alert("샘플이 추가되었습니다.");
                    window.location.href = "/sample/list";
                },
                error: function (e) {
                    console.error(e);
                }
            });
        }
    </script>
</head>
<body>
<h1>샘플 추가</h1>
<form id="sampleForm">
    <label for="name">이름:</label>
    <input type="text" id="name" name="name"/><br>
    <label for="value">값:</label>
    <input type="text" id="value" name="value"/><br>
    <button type="button" onclick="submitForm()">추가</button>
</form>
</body>
</html>
