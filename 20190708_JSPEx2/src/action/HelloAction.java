package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//개발 영역
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
		//JSPEx2/hello.do?name=홍길동		<=name = 홍길동
		//JSPEx2/hello.do?name=			<=name = isEmpty()

		//0순위 : 수신인코딩
		request.setCharacterEncoding("utf-8");
		
		//파라메터 수신
		String name =request.getParameter("name");
		
		if(name==null || name.isEmpty()) {
			name="아무게";
		}
		//request이용해서 값을 저장
		//binding API(데이터연결)
		//				key 	value
		request.setAttribute("name",name);
		
		
		//출력개체(JSP) forward
		RequestDispatcher disp =request.getRequestDispatcher("hello_result.jsp");
		//현재 servlet이 갖고있는 request,response를 그대로 전달
		disp.forward(request, response);
		
		
	}

}
