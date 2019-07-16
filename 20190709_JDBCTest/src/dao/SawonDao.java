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

	// 부서목록 얻어오기
	public List<SawonVo> selectList() {
		List<SawonVo> list = new ArrayList<SawonVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon";
		try {
			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2.SQL명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			// 3.명령수행후=>결과행 처리
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 레코드1개 저장객체
				SawonVo vo = new SawonVo();
				// 현재 rs의 위치(Cursor)
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				// ArrayList추가
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// 닫기(열린역순)
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
