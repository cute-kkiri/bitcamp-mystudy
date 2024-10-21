<%@ page
    language="java" 
    contentType="text/html;charset=UTF-8" 
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

<h1>회원 조회</h1>

<c:if test="${empty user}">
    <p>없는 회원입니다.</p>
</c:if>

<c:if test="${not empty user}">
    <form method="post" enctype='multipart/form-data'>
        <a href='https://kr.object.ncloudstorage.com/bitcamp-bucket106/user/${user.photo == null ? "default.png" : user.photo }'><br>
            <img src='https://qaosdurm4946.edge.naverncp.com/cgNpTbNYpL/user/${user.photo == null ? "default.png" : user.photo }?type=f&w=100&h=100&align=4'>
        </a><input name='file' type='file'><br>
        번호: <input name='no' readonly type='text' value='${user.no}'><br>
        이름: <input name='name' type='text' value='${user.name}'><br>
        이메일: <input name='email' type='email' value='${user.email}'><br>
        암호: <input name='password' type='password'><br>
        연락처: <input name='tel' type='tel' value='${user.tel}'><br>
        <button>변경</button>
        <button type='button' onclick='deleteUser(${user.no})'>삭제</button>
    </form>
</c:if>

<script>
    function deleteUser(no) {
        console.log("삭제 실행!");
        const xhr = new XMLHttpRequest();

        xhr.open("DELETE", location.href, true);

        xhr.onload = function () {
            if (xhr.status === 200) {
                location.href="../users";
            } else {
                window.alert("삭제 실패입니다!");
            }
        };

        xhr.send();
    }
</script>

</body>
</html>