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
		//idx�� �ش�Ǵ� �Խù� ���� ���´�.
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		// yes or no
		String result ="no";
		//��й�ȣ�� ������
		if(vo.getPwd().equals(c_pwd)) {
			result="yes";
		}
		// ���۽� JSON���� �����ؼ� ���� : {"result":"yes"} or {"result":"no"}
		String resultJSON = String.format("{\"result\":\"%s\"}", result);
		
		
		//response�̿��ؼ� ����� ����
		response.setContentType("text/plain; charset=utf-8;");
		response.getWriter().println(resultJSON);  //{"result":"yes"} or {"result":"no"} �̰� �Ѿ�´�..
	}

}
