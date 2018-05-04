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
		assertTrue(Letter.vowel('Ú'));
		assertTrue(Letter.vowel('I'));
		assertFalse(Letter.vowel('c'));
	}
	
	@Test
	public void testStrongVowel() {
		assertTrue(Letter.strongVowel('Ú'));
		assertFalse(Letter.strongVowel('I'));
		assertFalse(Letter.strongVowel('c'));
	}
	
	@Test
	public void testWeakVowel() {
		assertFalse(Letter.weakVowel('Ú'));
		assertTrue(Letter.weakVowel('I'));
		assertFalse(Letter.weakVowel('c'));
	}
	
	@Test
	public void testConsonant() {
		assertTrue(Letter.consonant('x'));
		assertTrue(Letter.consonant('Ñ'));
		assertFalse(Letter.consonant('a'));
	}
	
	@Test
	public void testAccent() {
		assertTrue(Letter.accent('ú'));
		assertFalse(Letter.accent('Ñ'));
		assertFalse(Letter.accent('a'));
	}
}
