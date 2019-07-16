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
		//System.out.write("--�λ縻 �˷��ֱ�--");
		//http://localhost:9090/20190703_ServletEx_30/say_hello.do?nation=kor
		//                                                        ?query 
		//                                                        ?parameter
		//client�� ��û�� parameter(nation)�� �޴´�
		String nation = request.getParameter("nation");
		
		if(nation==null)
			nation = "kor";
		
		//writer ���ö��� ���� �������� ���(�����߿�)

		System.out.printf("nation : %s\n", nation);
		
		String greet_message = "";
		
		switch(nation) 
		{
			case "kor": greet_message="(�ѱ���) �ȳ��ϼ���";break;
			case "eng": greet_message="(����) Hi Everyone";break;
			case "jpn": greet_message="(�Ϻ���) ���۳�������";break;
			case "chn": greet_message="(�߱���) ���Ͽ���";break;
			case "deu": greet_message="(���Ͼ�) ���ɼ�";break;
			case "fra": greet_message="(������) ���ָ�";break;
			default:   greet_message="(��Ÿ) Hello World";
		}
		//����ó��
		//���乮���� ���� ���� ����
		//                       mime type : image/jpg
		//                                   audio/wav          
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		//����(���� HTML����)
		out.write("<html>");
		out.write("<head><title>������ �λ縻</title></head>");
		out.write("<body>");
		out.write(greet_message);
		out.write("<hr>");
		out.write("<a href='say_hello.html'>�ٽ��ϱ�</a>");
		out.write("</body>");
		out.write("</html>");
	}

}
