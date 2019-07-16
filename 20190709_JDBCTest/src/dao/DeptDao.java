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
 * // Single-ton Pattern Code: ��ü�� 1���� �����ؼ� �����ϵ��� ... // �ڽ��� ��ü�� �����ϴ� ���� static
 * DeptDao single = null;
 * 
 * public static DeptDao getInstance() {
 * 
 * if (single == null) single = new DeptDao(); return single; }
 * 
 * // �μ���� ������ public List<DeptVo> selectList() { List<DeptVo> list = new
 * ArrayList<DeptVo>();
 * 
 * Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
 * String sql = "select * from dept";try { // 1.Connection ������ conn =
 * DBService.getInstance().getConnection(); // 2.SQL���ó����ü ������ pstmt =
 * conn.prepareStatement(sql); // 3.��ɼ�����=>����� ó�� rs = pstmt.executeQuery();
 * while (rs.next()) { // ���ڵ�1�� ���尴ü DeptVo vo = new DeptVo(); // ���� rs��
 * ��ġ(Cursor) vo.setDeptno(rs.getInt("deptno"));
 * vo.setDname(rs.getString("dname")); vo.setLoc(rs.getString("loc")); //
 * ArrayList�߰� list.add(vo); } }catch( Exception e) { // TODO: handle exception
 * e.printStackTrace(); }finally { try { // �ݱ�(��������) if (rs != null) rs.close();
 * if (pstmt != null) pstmt.close(); if (conn != null) conn.close(); } catch
 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }return list; }
 * 
 * }
 */