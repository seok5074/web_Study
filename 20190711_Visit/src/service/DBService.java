package service;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {

	
	DataSource ds;
	
	//Single-ton Pattern Code: ��ü�� 1���� �����ؼ� �����ϵ��� ...
	//�ڽ��� ��ü�� �����ϴ� ����
	static DBService single = null;

	public static DBService getInstance() {

		if (single == null)
			single = new DBService();
		return single;
	}
	
	private DBService() {
		// TODO Auto-generated constructor stub
		
		try {
			//JNDI������ ó���ϴ� ��ü
			InitialContext ic = new InitialContext();
			//�ڿ�(Resource�� ����)��ġ ���� �˻�
			Context context = (Context) ic.lookup("java:comp/env");
			
			//DataSource �˻�(Naming�˻�)
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
