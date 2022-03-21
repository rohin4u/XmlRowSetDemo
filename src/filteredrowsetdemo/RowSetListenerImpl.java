package filteredrowsetdemo;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class RowSetListenerImpl implements RowSetListener{

	@Override
	public void rowSetChanged(RowSetEvent event) {
		
		System.out.println("Row Set Changed");
		
	}

	@Override
	public void rowChanged(RowSetEvent event) {
		
		System.out.println("row changed");
		
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		
		System.out.println("cursor is moved");
		
	}

}
