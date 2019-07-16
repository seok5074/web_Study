package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.VisitVo;

public class VisitDao {
	
	//Single-ton Pattern Code: ��ü�� 1���� �����ؼ� �����ϵ��� ...
	//�ڽ��� ��ü�� �����ϴ� ����
	static VisitDao single = null;

	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();
		return single;
	}
	//���� ��� ��������
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//�ֱ� �ۼ��� �Խù� ������� ����
		String sql = "select * from visit order by idx desc";
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.SQL���ó����ü ������
			pstmt = conn.prepareStatement(sql);
			//3.��ɼ�����=>����� ó��
			rs = pstmt.executeQuery();
			//idx name content pwd ip regdate
			// 1 �ϱ浿~~~~~~~~~~~`
			
			while (rs.next()) {
				//���ڵ�1�� ���尴ü
				VisitVo vo = new VisitVo();
				//���� rs�� ��ġ(Cursor)
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				//ArrayList�߰�
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//�ݱ�(��������)
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	//���Ͼ���
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		int res = 0;//  parameter index=>           				 1 2 3 4 
		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";

		try {
			//1.Connection ���
			conn = DBService.getInstance().getConnection();
			//2.SQLó����ü ���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			//4.DB DML���
			// res : ó���� ��� 
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	//����
	public int delete(int idx) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		int res = 0;//  parameter index=>           
		String sql = "delete from visit where idx=?";

		try {
			//1.Connection ���
			conn = DBService.getInstance().getConnection();
			//2.SQLó����ü ���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setInt(1, idx);

			//4.DB DML���
			// res : ó���� ��� 
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	//�ҷ�����
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit where idx=?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.SQL���ó����ü ������
			pstmt = conn.prepareStatement(sql);
			//2-1 pstmt parameter����
			pstmt.setInt(1, idx);
			//3.��ɼ�����=>����� ó��
			rs = pstmt.executeQuery();

			if (rs.next()) {
				//���ڵ�1�� ���尴ü
				vo = new VisitVo();
				//���� rs�� ��ġ(Cursor)
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//�ݱ�(��������)
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	//����
	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		int res = 0;//  parameter index=>           
		String sql = "update visit set name=?,content=?,pwd=?,regdate=sysdate where idx=?";

		try {
			//1.Connection ���
			conn = DBService.getInstance().getConnection();
			//2.SQLó����ü ���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setInt(4, vo.getIdx());
			//4.DB DML���
			// res : ó���� ��� 
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
}
