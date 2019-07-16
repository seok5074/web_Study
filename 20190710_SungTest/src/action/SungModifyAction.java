package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungModifyAction
 */
@WebServlet("/sung/modify.do")
public class SungModifyAction extends HttpServlet {
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
		int no 		= Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		int    kor  = Integer.parseInt(request.getParameter("kor"));
		int    eng  = Integer.parseInt(request.getParameter("eng"));
		int    mat  = Integer.parseInt(request.getParameter("mat"));
		
		//3.����
		SungVo  vo = new SungVo(no,name, kor, eng, mat);
		
		//4.DB Insert
		int res = SungTBDao.getInstance().update(vo);
		
		//5.��Ϻ��� �̵�(redirect)
		response.sendRedirect("list.do");
	}

}
