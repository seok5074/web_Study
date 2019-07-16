package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitModifyFormAction
 */
@WebServlet("/visit/modify_form.do")
public class VisitModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//   /sung/modify_form.do?no=43
		
		//수정해야할 no를 받는다
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//수정할 1건의 성적데이터 얻어오기
		VisitVo  vo = VisitDao.getInstance().selectOne(idx);
		
		//DB : <br>로되있다. <textarea> :\r\n
		String content = vo.getContent().replaceAll("<br>", "\r\n");
		vo.setContent(content);
		
		//request binding
		request.setAttribute("vo", vo);//
		//forward
		String forward_page = "visit_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
