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
		Word test = new Word("ayúdame");
		Word corto = new Word("es");
		Word when = new Word("cuando");
		Word presentation = new Word("presentación");
		String separated = test.getSeparated();
		String separated2 = corto.getSeparated();
		String separated3 = when.getSeparated();
		String separated4 = presentation.getSeparated();
		assertTrue(separated.equals("a.'yú.da.me."));
		assertTrue(separated2.equals("'es."));
		assertTrue(separated3.equals("'cuan.do."));
		assertTrue(separated4.equals("pre.sen.ta.'ción."));
	}
}
