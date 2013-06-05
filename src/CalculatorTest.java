import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculatorTest {

//	@Test
//	public void testNull() {
//		assertTrue(new Calculator().add(null)==0);
//	}
//
//	@Test
//	public void testBlankValue() {
//		assertTrue(new Calculator().add("")==0);
//	}
//	
	@Test
	public void testOnekValue() {
		assertTrue(new Calculator().add("1")==1);
		assertTrue(new Calculator().add("100")==100);
	}
//	
	@Test
	public void testUnknownNumberOfValue() {
		assertTrue(new Calculator().add("1,2,3,4")==10);
	}
//	
	@Test
	public void testWithNewLine() {
		assertTrue(new Calculator().add("1\n2,3,4")==10);
	}
//	
	@Test
	public void testWithChangeDelimiter() {
		assertTrue(new Calculator().add("//[;]\n1\n2;3,4")==10);
		assertTrue(new Calculator().add("//[aaa]\n1\n2aaa3,4")==10);
		assertTrue(new Calculator().add("//[aaa]\n1\n2aaa3,4")==10);
	}
//	
	@Test
	public void testWithNegativeNumber() {
		Exception e = null;
		try {
			new Calculator().add("1,-2,3,-7");
		} catch (Exception e1) {
			// TODO: handle exception
			e=e1;
			System.out.println(e.getMessage());
		}
		assertTrue(e.getMessage().equals("negatives not allowed: -2, -7"));
	}
	@Test
	public void testWithNumberLagerThan1000() {
		assertTrue(new Calculator().add("1,2,3,1004")==10);
	}
	
	@Test
	public void testWithMultiDelimiter() {
		assertTrue(new Calculator().add("//[aaa][bbb][ccc]\n1aaa2bbb3ccc4")==10);
	}
}
