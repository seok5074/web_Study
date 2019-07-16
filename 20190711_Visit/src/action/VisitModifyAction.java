package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitModifyAction
 */
@WebServlet("/visit/modify.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        // /sung/insert.do?name=ȫ�浿&kor=11&eng=22&mat=33
		//1.�������ڵ� ����
		request.setCharacterEncoding("utf-8");
		//2.parameter�ޱ�
		int idx	=Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String content  = request.getParameter("content");
		String pwd  = request.getParameter("pwd");
		String ip  = request.getParameter("ip");
		
		content =content.replaceAll("\r\n", "<br>");
		
		//3.����
		VisitVo  vo = new VisitVo(idx,name,content,pwd,ip);
		
		//4.DB Insert
		int res = VisitDao.getInstance().update(vo);
		//5.��Ϻ��� �̵�(redirect)
		response.sendRedirect("list.do");
	}

}
