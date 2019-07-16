package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import myutil.Jumin;

/**
 * Servlet implementation class JuminInfoAction
 */
@WebServlet("/jumin.do")
public class JuminfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		// jumin.do?jumin_no=801212-1234560
		
		String jumin_no = request.getParameter("jumin_no");
		
		
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no);
		
		int year 		= jumin.getYear();
		String ganji 	= jumin.getGanji();
		int age			= jumin.getAge();
		String local	= jumin.getLocal();
		String season   = jumin.getSeason();
		String tti		= jumin.getTti();
		String sex		= jumin.getSex();
		
		StringBuffer sb1 = new StringBuffer();

		sb1.append("<style type='text/css'>");
		sb1.append("table{ width :400px;}");
		sb1.append("th{	width: 120px;}");
		sb1.append("td{ color: #0080c0;	padding-left: 10px;}");
		sb1.append("th,caption{ background-color: black;color:white;font-size: 16pt;font-weight: bold;}");
		sb1.append("</style>");
		
		sb1.append("<html>");
		sb1.append("<body>");
		sb1.append("<table border='1'>");
		sb1.append("<caption>::입력정보::</caption>");
		sb1.append("<tr><th>출생년도</th><td>");sb1.append(year+"년");	sb1.append("</td></tr>");
		sb1.append("<tr><th>출생년해</th><td>");sb1.append(ganji);	sb1.append("</td></tr>");
		sb1.append("<tr><th>출생계절</th><td>");sb1.append(season);sb1.append("</td></tr>");
		sb1.append("<tr><th>띠</th><td>");sb1.append(tti+"띠");sb1.append("</td></tr>");
		sb1.append("<tr><th>현재나이</th><td>");sb1.append(age+"살");sb1.append("</td></tr>");
		sb1.append("<tr><th>사는지역</th><td>");sb1.append(local);sb1.append("</td></tr>");
		sb1.append("<tr><th>성별</th><td>");sb1.append(sex);sb1.append("</td></tr>");
		sb1.append("<a href='jumin_input_form.html'>다시하기</a>");
		sb1.append("</body>");
		sb1.append("</html>");
		
		
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out =  response.getWriter();
		out.print(sb1.toString());
		
	}

}
