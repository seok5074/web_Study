package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
/*
 @ annotation
 :���α׷��ּ� (��ü�Ǵ� �޼ҵ� �ٿ����� ����ǥ)
   ������ü(��Ĺ �Ǵ� �ڹ�)�� ����ǥ�� �����ؼ� ���α׷��� ����
 */
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��û�� ip�ּ�
		String ip =request.getRemoteAddr();
		
		System.out.printf("--[%s]HelloAction:service() call--\n",ip);
	}

}
