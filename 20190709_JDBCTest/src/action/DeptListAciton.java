/*
 * package action;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import dao.DeptDao; import vo.DeptVo;
 * 
 *//**
	 * Servlet implementation class DeptListAciton
	 */
/*
 * @WebServlet("/dept/list.do") public class DeptListAciton extends HttpServlet
 * { private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void service(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub
		 * 
		 * //부서목록 요청 List<DeptVo> list = DeptDao.getInstance().selectList();
		 * 
		 * //request binding(공유) request.setAttribute("list", list);
		 * 
		 * //forward(출력은 dept_list.jsp에게 위임) RequestDispatcher disp =
		 * request.getRequestDispatcher("dept_list.jsp"); disp.forward(request,
		 * response); }
		 * 
		 * }
		 */
