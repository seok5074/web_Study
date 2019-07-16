package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//http://localhost:9090/20190703_SevletEx_30/calc.do?su1=1&su2=2
		
		int s1 = Integer.parseInt(request.getParameter("su1"));
		int s2 = Integer.parseInt(request.getParameter("su2"));
		
		
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>calc</title></head>");
		out.println("<body>");
		out.println(s1);out.println("+");out.println(s2);out.println("=");out.println(s1+s2);
		out.println("<br>");
		out.println(s1);out.println("-");out.println(s2);out.println("=");out.println(s1-s2);
		out.println("<br>");
		out.println(s1);out.println("*");out.println(s2);out.println("=");out.println(s1*s2);
		out.println("<br>");
		out.println(s1);out.println("/");out.println(s2);out.println("=");out.println(s1/s2);
		out.println("<br>");
		out.println(s1);out.println("%");out.println(s2);out.println("=");out.println(s1%s2);
		out.println("<br>");
		out.println("<hr>");
		out.println("<a href='calc.html'>다시하기</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
