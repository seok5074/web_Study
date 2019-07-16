package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungModifyFormAction
 */
@WebServlet("/sung/modify_form.do")
public class SungModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//   /sung/modify_form.do?no=43
		
		//�����ؾ��� no�� �޴´�
		int no = Integer.parseInt(request.getParameter("no"));
		
		//������ 1���� ���������� ������
		SungVo  vo = SungTBDao.getInstance().selectOne(no);
		
		//request binding
		request.setAttribute("vo", vo);
		

		//forward
		String forward_page = "sung_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
