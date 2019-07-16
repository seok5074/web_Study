package service;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {

	
	DataSource ds;
	
	//Single-ton Pattern Code: 객체를 1개만 생성해서 서비스하도록 ...
	//자신의 객체를 참조하는 변수
	static DBService single = null;

	public static DBService getInstance() {

		if (single == null)
			single = new DBService();
		return single;
	}
	
	private DBService() {
		// TODO Auto-generated constructor stub
		
		try {
			//JNDI정보를 처리하는 객체
			InitialContext ic = new InitialContext();
			//자원(Resource가 저장)위치 정보 검색
			Context context = (Context) ic.lookup("java:comp/env");
			
			//DataSource 검색(Naming검색)
			ds = (DataSource) context.lookup("jdbc/oracle_test");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() throws Exception {
		
		Connection conn = null;
		
		conn = ds.getConnection();
		
		return conn;
	}
	
	
}
