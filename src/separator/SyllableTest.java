package separator;

import static org.junit.Assert.*;

import org.junit.Test;

public class SyllableTest {

	@Test
	public void getTest() {
		Syllable s = new Syllable("es");
		assertTrue(s.getSyllable().equals("es"));
	}
	
	@Test
	public void setTest() {
		Syllable slash = new Syllable("/cor");
		Syllable noSlash = new Syllable("cor");
		slash.setStressed();
		noSlash.setStressed();
		assertTrue(slash.getSyllable().equals("/'cor"));
		assertTrue(noSlash.getSyllable().equals("'cor"));
	}
}
