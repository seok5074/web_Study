package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, //요청처리객체
							HttpServletResponse response) //응답처리객체
							throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청자 IP주소
		String ip = request.getRemoteAddr();
		//System.out.printf("--[%s]:HelloAction:service() call--\n",ip);
		
		//전송메시지 포장
		String message= String.format("[%s] 님 방문을 환영합니다.", ip);
		//응답내용 포함한 HTML생성
		StringBuffer sb =new StringBuffer();
		sb.append("<html>");
		sb.append("<head><title>응답내용</title></head>");
		sb.append("<body>");
		sb.append(message);
		sb.append("</body>");
		sb.append("</html>");
		
		//전송문서에 정보 셋팅
		response.setContentType("text/html; charset=utf-8;");
		
		//응답처리 객체로부터 전송문자 스트림 얻어오기
		PrintWriter out =response.getWriter();
		
		//응답하기
		out.println(sb.toString());
	}
}
