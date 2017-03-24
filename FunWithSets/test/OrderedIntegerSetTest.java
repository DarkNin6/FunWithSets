import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedIntegerSetTest {
	
	OrderedIntegerSet s = new OrderedIntegerSet(10);
	OrderedIntegerSet singleton = new OrderedIntegerSet(1);

	@Test
	public void testFindAdd() {
		assertEquals("find: Incorrectly returns a positive position for non-existent number" ,-1, s.find(4));
		s.add(4);
		assertEquals("find: Returned incorrect position for existent number" ,0, s.find(4));
		s.add(3);
		assertEquals("find: Returned incorrect position for existent number" ,0, s.find(3));		
		assertEquals("find: Returned incorrect position for existent number" ,1, s.find(4));		
		s.delete(4);
		s.delete(3);
	}

}
