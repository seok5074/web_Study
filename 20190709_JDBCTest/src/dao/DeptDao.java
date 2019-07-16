/*
 * package dao;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.util.ArrayList;
 * import java.util.List;
 * 
 * import service.DBService; import vo.DeptVo;
 * 
 * public class DeptDao {
 * 
 * // Single-ton Pattern Code: 객체를 1개만 생성해서 서비스하도록 ... // 자신의 객체를 참조하는 변수 static
 * DeptDao single = null;
 * 
 * public static DeptDao getInstance() {
 * 
 * if (single == null) single = new DeptDao(); return single; }
 * 
 * // 부서목록 얻어오기 public List<DeptVo> selectList() { List<DeptVo> list = new
 * ArrayList<DeptVo>();
 * 
 * Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
 * String sql = "select * from dept";try { // 1.Connection 얻어오기 conn =
 * DBService.getInstance().getConnection(); // 2.SQL명령처리객체 얻어오기 pstmt =
 * conn.prepareStatement(sql); // 3.명령수행후=>결과행 처리 rs = pstmt.executeQuery();
 * while (rs.next()) { // 레코드1개 저장객체 DeptVo vo = new DeptVo(); // 현재 rs의
 * 위치(Cursor) vo.setDeptno(rs.getInt("deptno"));
 * vo.setDname(rs.getString("dname")); vo.setLoc(rs.getString("loc")); //
 * ArrayList추가 list.add(vo); } }catch( Exception e) { // TODO: handle exception
 * e.printStackTrace(); }finally { try { // 닫기(열린역순) if (rs != null) rs.close();
 * if (pstmt != null) pstmt.close(); if (conn != null) conn.close(); } catch
 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }return list; }
 * 
 * }
 */