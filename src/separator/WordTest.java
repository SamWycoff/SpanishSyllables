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
		Word test = new Word("ayúdame");
		Word testWord = new Word("bucket");
		Word testWords = new Word("buckets");
		Word corto = new Word("es");
		String separated = test.stressedSyllable();
		String separated1 = testWord.stressedSyllable();
		String separated3 = testWords.stressedSyllable();
		String separated2 = corto.stressedSyllable();
		assertTrue(separated.equals("a.'yú.da.me."));
		assertTrue(separated1.equals("bu.cke.'t."));
		assertTrue(separated3.equals("bu.'cke.ts."));
		assertTrue(separated2.equals("'es."));
	}
}
