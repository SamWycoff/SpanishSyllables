package separator;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordTest {
	@Test
	public void testConstruct() {
		Word testWord = new Word("bueno");
		assertTrue(testWord.getWord().equals("bueno"));
	}
	
	@Test
	public void testSeparate() {
		Word test = new Word("ay�dame");
		Word corto = new Word("es");
		Word when = new Word("cuando");
		Word presentation = new Word("presentaci�n");
		String separated = test.stressedSyllable();
		String separated2 = corto.stressedSyllable();
		String separated3 = when.stressedSyllable();
		String separated4 = presentation.stressedSyllable();
		assertTrue(separated.equals("a.'y�.da.me."));
		assertTrue(separated2.equals("'es."));
		assertTrue(separated3.equals("'cuan.do."));
		assertTrue(separated4.equals("pre.sen.ta.'ci�n."));
	}
}
