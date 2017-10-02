package com.fdmgroup.demos;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class StorageTest{

	@Test
	public void testApplicationCallsStoreMethodInStorage(){
		
		Storage storage = mock(Storage.class);
		Object object = mock(Object.class);
		Application app = new Application(storage);
		
		app.process(object);
		
		verify(storage,times(1)).store(eq(object));
		
	}
	
}