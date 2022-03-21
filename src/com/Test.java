package com;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class Test {

	public static void main(String[] args) throws SQLException, IOException {
		
		RowSetFactory rsf=RowSetProvider.newFactory();
		WebRowSet rs=rsf.createWebRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("system");
		rs.setPassword("password");
		rs.setCommand("select * from employee");
		rs.execute();
		FileWriter fw=new FileWriter("emp.xml");
		rs.writeXml(fw);
		System.out.println("Employee Data transfered to emp.xml file");
		fw.close();

	}

}
