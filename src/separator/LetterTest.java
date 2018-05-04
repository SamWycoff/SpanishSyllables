package separator;

import static org.junit.Assert.*;
import org.junit.Test;

public class LetterTest {

	@Test
	public void testIsLetter() {
		assertTrue(Letter.isLetter('c'));
		assertTrue(Letter.isLetter('0'));
		assertFalse(Letter.isLetter('&'));
	}
	
	@Test
	public void testVowel() {
		assertTrue(Letter.vowel('�'));
		assertTrue(Letter.vowel('I'));
		assertFalse(Letter.vowel('c'));
	}
	
	@Test
	public void testStrongVowel() {
		assertTrue(Letter.strongVowel('�'));
		assertFalse(Letter.strongVowel('I'));
		assertFalse(Letter.strongVowel('c'));
	}
	
	@Test
	public void testWeakVowel() {
		assertFalse(Letter.weakVowel('�'));
		assertTrue(Letter.weakVowel('I'));
		assertFalse(Letter.weakVowel('c'));
	}
	
	@Test
	public void testConsonant() {
		assertTrue(Letter.consonant('x'));
		assertTrue(Letter.consonant('�'));
		assertFalse(Letter.consonant('a'));
	}
	
	@Test
	public void testAccent() {
		assertTrue(Letter.accent('�'));
		assertFalse(Letter.accent('�'));
		assertFalse(Letter.accent('a'));
	}
}
