package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register.do")
public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * http://localhost:9090/20190704_ServletParameter/member_register.do?
		 * name=%ED%99%8D%EA%B8%B8%EB%8F%99& id=hong123&pwd=1324&
		 * gender=%EB%82%A8%EC%9E%90& friend=& friend=& friend=& blood=A& profile=
		 */		
		//0순위로 해야할거 : 수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		String name =request.getParameter("name");
		String id =request.getParameter("id");
		String pwd =request.getParameter("pwd");
		String gender =request.getParameter("gender");
		String [] hobby_array=request.getParameterValues("hobby");
		String hobby_list="취미없음";
		if(hobby_array !=null) { //null 아니라는건 취미가 있을경우
			StringBuffer sb = new StringBuffer();
			for(String hobby: hobby_array) {
				sb.append(hobby);
				sb.append(" ");
			}
			hobby_list=sb.toString();
		}
		//System.out.println(hobby_list);
		//System.out.println(name);
		//System.out.println(id);
		//System.out.println(pwd);
		
		//친구목록
		// /member_register.do?freind=&friend=&friend=
		String [] friend_array = request.getParameterValues("friend");
		//String [] friend_array={"개똥이","말자","홀리"};
		String friend_list="";
		
		StringBuffer sb1 = new StringBuffer();

		for(String friend : friend_array) {
				sb1.append(friend);
				sb1.append(" ");
		}
		friend_list =sb1.toString().trim();//값이 없을경우 공백이 3개들어왔다. trim을 사용 공백도 없어짐  
		if(friend_list.isEmpty())
			friend_list="친구없음";
		
		String blood =request.getParameter("blood");
		String profile =request.getParameter("profile");
		
		
		sb1.append("<style type='text/css'>");
		sb1.append("table{ width :400px;}");
		sb1.append("th{	width: 120px;}");
		sb1.append("td{ color: #0080c0;	padding-left: 10px;}");
		sb1.append("th,caption{ background-color: black;color:white;font-size: 16pt;font-weight: bold;}");
		sb1.append("</style>");
		//수신결과를 이용해서 입력받은거 클라이언트에 보여주기
		sb1.append("<html>");
		sb1.append("<body>");
		sb1.append("<table border='1'>");
		sb1.append("<caption>::입력정보::</caption>");
		sb1.append("<tr><th>이름</th><td>");sb1.append(name);	sb1.append("</td></tr>");
		sb1.append("<tr><th>아이디</th><td>");sb1.append(id);	sb1.append("</td></tr>");
		sb1.append("<tr><th>비밀번호</th><td>");sb1.append(pwd);	sb1.append("</td></tr>");
		sb1.append("<tr><th>성별</th><td>");sb1.append(gender);	sb1.append("</td></tr>");
		sb1.append("<tr><th>취미</th><td>");sb1.append(hobby_list);	sb1.append("</td></tr>");
		sb1.append("<tr><th>친구</th><td>");sb1.append(friend_list);	sb1.append("</td></tr>");
		sb1.append("<tr><th>혈액형</th><td>");sb1.append(blood);	sb1.append("</td></tr>");
		sb1.append("<tr><th>자기소개</th><td>");sb1.append(profile);	sb1.append("</td></tr>");
		sb1.append("</body>");
		sb1.append("</html>");
		
		
		response.setContentType("text/html;charset=utf-8;");
		//
		PrintWriter out =  response.getWriter();
		out.print(sb1.toString());
	}

}
