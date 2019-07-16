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
@WebServlet("/calc2.do")
public class CalcAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//20190703_ServletEx_30/calc.do?su1=1&su2=2
		//parameter�ޱ�
		String str_su1 = request.getParameter("su1");
		String str_su2 = request.getParameter("su2");
		//������ȯ
		int su1 = Integer.parseInt(str_su1);
		int su2 = Integer.parseInt(str_su2);
		//�������� HTML����
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head><title>���</title></head>");
		sb.append("<body>");
		sb.append("::::�����::::<br>");
		sb.append(String.format("%d + %d = %d<br>", su1,su2, su1 + su2));
		sb.append(String.format("%d - %d = %d<br>", su1,su2, su1 - su2));
		sb.append(String.format("%d * %d = %d<br>", su1,su2, su1 * su2));
		sb.append(String.format("%d / %d = %d<br>", su1,su2, su2==0 ? 0: su1 / su2));
		sb.append(String.format("%d %% %d = %d<br>", su1,su2, su1 % su2));
		sb.append("<a href='calc2.html'>�ٽ��ϱ�</a>");
		sb.append("</body>");
		sb.append("</html>");
		
		
		response.setContentType("text/html;charset=utf-8;");
		//
		PrintWriter out =  response.getWriter();
		out.print(sb.toString());
		
	}

}
