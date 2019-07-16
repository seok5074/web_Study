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
 :프로그램주석 (객체또는 메소드등에 붙여지는 꼬리표)
   수행주체(톰캣 또는 자바)가 꼬리표를 참조해서 프로그램을 참조
 */
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청자 ip주소
		String ip =request.getRemoteAddr();
		
		System.out.printf("--[%s]HelloAction:service() call--\n",ip);
	}

}
