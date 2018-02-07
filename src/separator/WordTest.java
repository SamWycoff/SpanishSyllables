package separator;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordTest {
	@Test
	public void testConstruct() {
		Word testWord = new Word("buckets");
		assertTrue(testWord.getWord().equals("buckets"));
	}
	
	@Test
	public void testSeparate() {
		
	}
}
