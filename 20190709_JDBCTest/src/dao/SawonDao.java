package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SawonVo;

public class SawonDao {
	static SawonDao single = null;

	public static SawonDao getInstance() {
		if (single == null)
			single = new SawonDao();
		return single;
	}

	// �μ���� ������
	public List<SawonVo> selectList() {
		List<SawonVo> list = new ArrayList<SawonVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon";
		try {
			// 1.Connection ������
			conn = DBService.getInstance().getConnection();
			// 2.SQL���ó����ü ������
			pstmt = conn.prepareStatement(sql);
			// 3.��ɼ�����=>����� ó��
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// ���ڵ�1�� ���尴ü
				SawonVo vo = new SawonVo();
				// ���� rs�� ��ġ(Cursor)
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				// ArrayList�߰�
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// �ݱ�(��������)
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

}
