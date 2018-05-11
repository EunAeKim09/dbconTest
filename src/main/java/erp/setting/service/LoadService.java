package erp.setting.service;

import java.util.Properties;

import erp.setting.dao.ExecuteSql;
import kr.or.dgit.erp_application_jdbc.LoadProperties;

public class LoadService implements DaoService {
	private static final LoadService instance = new LoadService();
	
	public static LoadService getInstance() {
		return instance;
	}

	private LoadService() {};
	
	@Override
	public void service() {
		LoadProperties loadProperties = new LoadProperties();
		Properties properteis = loadProperties.getProperties();
		
		ExecuteSql.getInstance().exexSQL("use " + properteis.getProperty("dbname"));
		ExecuteSql.getInstance().exexSQL("set foreign_key_checks=0");
		
		
		String [] tables = properteis.get("tables").toString().split(",");
		for(String tblname : tables) {
			String path = String.format("%s\\DataFiles\\%s.csv", System.getProperty("user.dir"), tblname);
			String sql = String.format("load data local infile '%s' into table %s character set 'utf8' fields terminated by ','", 
					path, tblname);
			
			sql = sql.replace("\\", "/");
			ExecuteSql.getInstance().exexSQL(sql);
			
		}
		ExecuteSql.getInstance().exexSQL("set foreign_key_checks=1");
	}

}
