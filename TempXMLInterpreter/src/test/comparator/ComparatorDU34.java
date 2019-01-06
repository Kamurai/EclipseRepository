package test.comparator;

import com.cedarsoftware.util.*;

import information.FileObject;
import information.dU34.Message;
import information.uLDD30.Mes.About_Version;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComparatorDU34 {
	Message a = new Message();
	Message b = new Message();
	
	About_Version aav = new About_Version();
	About_Version bav = new About_Version();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		aav.setCreatedDatetime(LocalDateTime.now());
		ArrayList<About_Version> laav = new ArrayList<About_Version>();
		laav.add(aav);
		a.setAbout_Versions(laav);
		
		bav.setCreatedDatetime(LocalDateTime.now());
		ArrayList<About_Version> lbav = new ArrayList<About_Version>();
		lbav.add(bav);
		b.setAbout_Versions(lbav);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(DeepEquals.deepEquals(a, b),true);
	}

}
