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
		//0������ �ؾ��Ұ� : ���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		String name =request.getParameter("name");
		String id =request.getParameter("id");
		String pwd =request.getParameter("pwd");
		String gender =request.getParameter("gender");
		String [] hobby_array=request.getParameterValues("hobby");
		String hobby_list="��̾���";
		if(hobby_array !=null) { //null �ƴ϶�°� ��̰� �������
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
		
		//ģ�����
		// /member_register.do?freind=&friend=&friend=
		String [] friend_array = request.getParameterValues("friend");
		//String [] friend_array={"������","����","Ȧ��"};
		String friend_list="";
		
		StringBuffer sb1 = new StringBuffer();

		for(String friend : friend_array) {
				sb1.append(friend);
				sb1.append(" ");
		}
		friend_list =sb1.toString().trim();//���� ������� ������ 3�����Դ�. trim�� ��� ���鵵 ������  
		if(friend_list.isEmpty())
			friend_list="ģ������";
		
		String blood =request.getParameter("blood");
		String profile =request.getParameter("profile");
		
		
		sb1.append("<style type='text/css'>");
		sb1.append("table{ width :400px;}");
		sb1.append("th{	width: 120px;}");
		sb1.append("td{ color: #0080c0;	padding-left: 10px;}");
		sb1.append("th,caption{ background-color: black;color:white;font-size: 16pt;font-weight: bold;}");
		sb1.append("</style>");
		//���Ű���� �̿��ؼ� �Է¹����� Ŭ���̾�Ʈ�� �����ֱ�
		sb1.append("<html>");
		sb1.append("<body>");
		sb1.append("<table border='1'>");
		sb1.append("<caption>::�Է�����::</caption>");
		sb1.append("<tr><th>�̸�</th><td>");sb1.append(name);	sb1.append("</td></tr>");
		sb1.append("<tr><th>���̵�</th><td>");sb1.append(id);	sb1.append("</td></tr>");
		sb1.append("<tr><th>��й�ȣ</th><td>");sb1.append(pwd);	sb1.append("</td></tr>");
		sb1.append("<tr><th>����</th><td>");sb1.append(gender);	sb1.append("</td></tr>");
		sb1.append("<tr><th>���</th><td>");sb1.append(hobby_list);	sb1.append("</td></tr>");
		sb1.append("<tr><th>ģ��</th><td>");sb1.append(friend_list);	sb1.append("</td></tr>");
		sb1.append("<tr><th>������</th><td>");sb1.append(blood);	sb1.append("</td></tr>");
		sb1.append("<tr><th>�ڱ�Ұ�</th><td>");sb1.append(profile);	sb1.append("</td></tr>");
		sb1.append("</body>");
		sb1.append("</html>");
		
		
		response.setContentType("text/html;charset=utf-8;");
		//
		PrintWriter out =  response.getWriter();
		out.print(sb1.toString());
	}

}
