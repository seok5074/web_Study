package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SayHelloAction
 */
@WebServlet("/say_hello.do")
public class SayHelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.write("--인사말 알려주기--");
		//http://localhost:9090/20190703_ServletEx_30/say_hello.do?nation=kor
		//                                                        ?query 
		//                                                        ?parameter
		//client가 요청한 parameter(nation)를 받는다
		String nation = request.getParameter("nation");
		
		if(nation==null)
			nation = "kor";
		
		//writer 얻어올때는 먼저 설정부터 얻고(순서중요)

		System.out.printf("nation : %s\n", nation);
		
		String greet_message = "";
		
		switch(nation) 
		{
			case "kor": greet_message="(한국어) 안녕하세요";break;
			case "eng": greet_message="(영어) Hi Everyone";break;
			case "jpn": greet_message="(일본어) 오겡끼데스까";break;
			case "chn": greet_message="(중국어) 니하오마";break;
			case "deu": greet_message="(독일어) 당케셰";break;
			case "fra": greet_message="(프랑어) 봉주르";break;
			default:   greet_message="(기타) Hello World";
		}
		//응답처리
		//응답문서에 대한 정보 설정
		//                       mime type : image/jpg
		//                                   audio/wav          
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		//전송(동적 HTML생성)
		out.write("<html>");
		out.write("<head><title>각나라 인사말</title></head>");
		out.write("<body>");
		out.write(greet_message);
		out.write("<hr>");
		out.write("<a href='say_hello.html'>다시하기</a>");
		out.write("</body>");
		out.write("</html>");
	}

}
