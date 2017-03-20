import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerSetTest {

	IntegerSet s = new IntegerSet(10);
	IntegerSet singleton = new IntegerSet(1);

	@Test
	public void testIsMember() {
		assertFalse("isMember: incorrectly returns true", s.isMember(5));
	}

	@Test
	public void testAdd() {
		s.add(5);
		assertTrue("isMember: incorrectly returns false", s.isMember(5));		
	}

	@Test
	public void testAddFull() {
		singleton.add(5);
		singleton.add(6);
		assertTrue("isMember: incorrectly returns false", singleton.isMember(5));		
		assertTrue("isMember: incorrectly returns false", singleton.isMember(6));		
		assertFalse("isMember: incorrectly returns true", singleton.isMember(7));		
		singleton.delete(6);
		singleton.delete(5);
	}
	
	@Test
	public void testDelete() {
		s.add(10);
		s.add(11);
		s.delete(11);
		assertFalse("delete: did not remove properly", s.isMember(11));
		s.delete(10);
	}


}
