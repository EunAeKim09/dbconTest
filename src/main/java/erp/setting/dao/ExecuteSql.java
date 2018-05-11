package erp.setting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.dgit.erp_application_jdbc.DBCon;

public class ExecuteSql {
	private static final ExecuteSql instance = new ExecuteSql();

	public static ExecuteSql getInstance() {
		return instance;
	}

	private ExecuteSql() {
		// TODO Auto-generated constructor stub
	}

	public void exexSQL(String sql) {
		System.out.println(sql);
		Connection con = DBCon.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
			System.out.printf("%s~%s%n", e.getErrorCode(), e.getMessage());
		}
	};

	public ResultSet exeQuerySQL(String sql) throws SQLException {
		Connection con = DBCon.getInstance().getConnection();
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
}
