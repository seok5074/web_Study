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
 * Servlet implementation class CheckPwdAction
 */
@WebServlet("/visit/check_pwd.do")
public class CheckPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /visit/check_pwd.do?idx=10&c_pwd=1234
		int idx =Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		//idx에 해당되는 게시물 정보 얻어온다.
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		// yes or no
		String result ="no";
		//비밀번호가 같으면
		if(vo.getPwd().equals(c_pwd)) {
			result="yes";
		}
		// 전송시 JSON으로 포장해서 전송 : {"result":"yes"} or {"result":"no"}
		String resultJSON = String.format("{\"result\":\"%s\"}", result);
		
		
		//response이용해서 결과를 전송
		response.setContentType("text/plain; charset=utf-8;");
		response.getWriter().println(resultJSON);  //{"result":"yes"} or {"result":"no"} 이게 넘어온다..
	}

}
