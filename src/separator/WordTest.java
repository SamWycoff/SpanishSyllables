package separator;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordTest {
	@Test
	public void testGet() {
		Word testWord = new Word("bueno");
		assertTrue(testWord.getWord().equals("bueno"));
	}
	
	@Test
	public void testSeparate() {
		Word test = new Word("ayúdame");
		Word corto = new Word("es");
		Word when = new Word("cuando");
		Word presentation = new Word("presentación");
		Word slash = new Word("bueno/");
		String separated = test.getSeparated();
		String separated2 = corto.getSeparated();
		String separated3 = when.getSeparated();
		String separated4 = presentation.getSeparated();
		String separated5 = slash.getSeparated();
		assertTrue(separated.equals("a.'yú.da.me."));
		assertTrue(separated2.equals("'es."));
		assertTrue(separated3.equals("'cuan.do."));
		assertTrue(separated4.equals("pre.sen.ta.'ción."));
		assertTrue(separated5.equals("'bue.no/"));
	}
	
	@Test
	public void testVowelSeparate() {
		Word presentation = new Word("presentación");
		Word shortWord = new Word("corto");
		Word city = new Word("ciudad");
		Word frame = new Word("cuadro");
		Word aorta = new Word("aorta");
		assertFalse(shortWord.vowelSeparate(4));
		assertFalse(city.vowelSeparate(1));
		assertTrue(presentation.vowelSeparate(7));
		assertFalse(presentation.vowelSeparate(4));
		assertTrue(frame.vowelSeparate(2));
		assertFalse(presentation.vowelSeparate(9));
		assertTrue(aorta.vowelSeparate(0));
		assertFalse(presentation.vowelSeparate(10));
	}
	
	@Test
	public void testConsonantSeparate() {
		Word presentation = new Word("presentación");
		Word buy = new Word("comprar");
		Word frame = new Word("cuadro");
		assertFalse(presentation.consonantSeparate(11));
		assertFalse(frame.consonantSeparate(3));
		assertTrue(buy.consonantSeparate(2));
		assertTrue(presentation.consonantSeparate(5));
		assertFalse(presentation.consonantSeparate(3));
	}
}
