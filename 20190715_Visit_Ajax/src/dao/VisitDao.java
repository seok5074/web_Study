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
	
	//Single-ton Pattern Code: 객체를 1개만 생성해서 서비스하도록 ...
	//자신의 객체를 참조하는 변수
	static VisitDao single = null;

	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();
		return single;
	}
	//방명록 목록 가져오기
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//최근 작성된 게시물 순서대로 정렬
		String sql = "select * from visit order by idx desc";
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.SQL명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			//3.명령수행후=>결과행 처리
			rs = pstmt.executeQuery();
			//idx name content pwd ip regdate
			// 1 일길동~~~~~~~~~~~`
			
			while (rs.next()) {
				//레코드1개 저장객체
				VisitVo vo = new VisitVo();
				//현재 rs의 위치(Cursor)
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				//ArrayList추가
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//닫기(열린역순)
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
	//방명록쓰기
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		int res = 0;//  parameter index=>           				 1 2 3 4 
		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";

		try {
			//1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			//2.SQL처리객체 얻기
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter 셋팅
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			//4.DB DML명령
			// res : 처리된 행수 
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
	//삭제
	public int delete(int idx) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		int res = 0;//  parameter index=>           
		String sql = "delete from visit where idx=?";

		try {
			//1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			//2.SQL처리객체 얻기
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter 셋팅
			pstmt.setInt(1, idx);

			//4.DB DML명령
			// res : 처리된 행수 
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
	//불러오기
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit where idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.SQL명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			//2-1 pstmt parameter셋팅
			pstmt.setInt(1, idx);
			//3.명령수행후=>결과행 처리
			rs = pstmt.executeQuery();

			if (rs.next()) {
				//레코드1개 저장객체
				vo = new VisitVo();
				//현재 rs의 위치(Cursor)
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
				//닫기(열린역순)
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
	//수정
	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		int res = 0;//  parameter index=>           
		String sql = "update visit set name=?,content=?,pwd=?,regdate=sysdate where idx=?";

		try {
			//1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			//2.SQL처리객체 얻기
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter 셋팅
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setInt(4, vo.getIdx());
			//4.DB DML명령
			// res : 처리된 행수 
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
