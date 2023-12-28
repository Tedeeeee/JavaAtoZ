<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // jsp 내부에서는 자동으로 request와 response는 자동으로 사용이 가능하다.
  MemberRepository memberRepository = MemberRepository.getInstance();

  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  성공
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></>
  <li>age=<%=member.getAge()%></>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
