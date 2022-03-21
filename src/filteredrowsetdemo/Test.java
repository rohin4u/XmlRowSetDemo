package filteredrowsetdemo;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Test {
	
	public static void main(String[] args) throws SQLException {
		
	
	RowSetFactory rsf=RowSetProvider.newFactory();
	JdbcRowSet rs = rsf.createJdbcRowSet();
	rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	rs.setUsername("system");
	rs.setPassword("password");
	rs.setCommand("select emp,eid,eaddr from employee");
	rs.addRowSetListener(new RowSetListenerImpl());
	rs.execute();
	while(rs.next()){
	System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	}
	rs.moveToInsertRow();
	rs.updateString(1, "Atul");
	rs.updateString(2, "AU-999");
	rs.updateString(3, "Chennai");
	rs.insertRow();
	rs.close();
	}

}
