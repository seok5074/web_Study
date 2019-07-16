package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���� ����
/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//JSPEx2/hello.do?				<=name = null
		//JSPEx2/hello.do?name=ȫ�浿		<=name = ȫ�浿
		//JSPEx2/hello.do?name=			<=name = isEmpty()

		//0���� : �������ڵ�
		request.setCharacterEncoding("utf-8");
		
		//�Ķ���� ����
		String name =request.getParameter("name");
		
		if(name==null || name.isEmpty()) {
			name="�ƹ���";
		}
		//request�̿��ؼ� ���� ����
		//binding API(�����Ϳ���)
		//				key 	value
		request.setAttribute("name",name);
		
		
		//��°�ü(JSP) forward
		RequestDispatcher disp =request.getRequestDispatcher("hello_result.jsp");
		//���� servlet�� �����ִ� request,response�� �״�� ����
		disp.forward(request, response);
		
		
	}

}
