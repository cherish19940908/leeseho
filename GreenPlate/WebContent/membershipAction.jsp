<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO"%>
<%@ page import="java.io.PrintWriter"%>
<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="dto" class="member.MemberDTO" scope="page" />
<jsp:setProperty name="dto" property="*" />
<jsp:setProperty name="dto" property="nick" />
<jsp:setProperty name="dto" property="pw" />
<jsp:setProperty name="dto" property="pwhint" />
<jsp:setProperty name="dto" property="pwa" />
<jsp:setProperty name="dto" property="name" />
<jsp:setProperty name="dto" property="email" />
<jsp:setProperty name="dto" property="age" />
<jsp:setProperty name="dto" property="home" />
<jsp:setProperty name="dto" property="dethome" />
<jsp:setProperty name="dto" property="postnum" />
<jsp:setProperty name="dto" property="cell" />
<jsp:setProperty name="dto" property="sex" />





<!DOCTYPE html>
<html>
<head>
<meta http-equive="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<%   
String id =null;     
if(session.getAttribute("id")!=null){  //로그인이 되어있는지를 확인하기위해서 세션이 셋 되어 있으면 아이디 변수에 로그인된 아이디를 저장해둔다
id = (String)session.getAttribute("id");  	  
}
	 MemberDAO userDAO = new MemberDAO(); 
     int result = userDAO.join(dto);
         if(result ==-1){
        	 PrintWriter script = response.getWriter();
        	 script.println("<script>");
        	 script.println("alert('이미존재하는 아이디입니다.')");
        	 script.println("history.back()"); 
        	 script.println("</script>");
        	 
         }else if(result == 1){
        	 session.setAttribute("id",dto.getId());
        	 session.setAttribute("nic",dto.getNick());
        	 PrintWriter script = response.getWriter();
     
        	 script.println("<script>");
 
        	 script.println("location.href = 'gpindex.jsp'");	 

        	 script.println("</script>");
        	 
         }

%>
</body>
</html>
