package tests;
import static org.junit.Assert.*;
import infixtoposix.InToPost;

import org.junit.Test;

public class PublicTests {

	@Test
	public void test1() {
		String input = "1+2*3/3";
		InToPost<String> output = new InToPost<String>(input);
		assertTrue((output.convertToPost()).equals("123*3/+"));
	}
	
	@Test
	public void test2() {
		String input = "(15/5)+(10-3)";
		InToPost<String> output = new InToPost<String>(input);
		assertTrue((output.convertToPost()).equals("155/103-+"));
	}

}
