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
 * Servlet implementation class visitDeleteAction
 */
@WebServlet("/visit/delete.do")
public class visitDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받기
		int idx 	=Integer.parseInt(request.getParameter("idx"));
		
		
		//5.DB insert
		int res = VisitDao.getInstance().delete(idx);		
		//6.목록보기  현재위치 : /visit/insert.do
		response.sendRedirect("list.do");
	}

}
