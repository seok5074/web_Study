package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, //��ûó����ü
							HttpServletResponse response) //����ó����ü
							throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��û�� IP�ּ�
		String ip = request.getRemoteAddr();
		//System.out.printf("--[%s]:HelloAction:service() call--\n",ip);
		
		//���۸޽��� ����
		String message= String.format("[%s] �� �湮�� ȯ���մϴ�.", ip);
		//���䳻�� ������ HTML����
		StringBuffer sb =new StringBuffer();
		sb.append("<html>");
		sb.append("<head><title>���䳻��</title></head>");
		sb.append("<body>");
		sb.append(message);
		sb.append("</body>");
		sb.append("</html>");
		
		//���۹����� ���� ����
		response.setContentType("text/html; charset=utf-8;");
		
		//����ó�� ��ü�κ��� ���۹��� ��Ʈ�� ������
		PrintWriter out =response.getWriter();
		
		//�����ϱ�
		out.println(sb.toString());
	}
}
