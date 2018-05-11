package erp.setting;

import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.Properties;

import kr.or.dgit.erp_application_jdbc.DBCon;
import kr.or.dgit.erp_application_jdbc.LoadProperties;

public class TestMain {
	public static void main(String[] args) throws SQLException, InterruptedException {
		testDBconnection();
	}

	private static void testDBconnection() {
		DBCon dbCon = DBCon.getInstance();
		System.out.println(dbCon);

		LoadProperties lp = new LoadProperties();
		Properties pro = lp.getProperties();

		for(Entry<Object, Object> e : pro.entrySet()) {
			System.out.printf("%s : %s%n", e.getKey(), e.getValue());
		}
	}
}
