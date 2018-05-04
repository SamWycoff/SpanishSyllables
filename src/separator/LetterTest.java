package separator;

import org.junit.Assert;
import org.junit.Test;

public class LetterTest {

	@Test
	public void testIsLetter() {
		Assert.assertTrue(Letter.isLetter('c'));
		Assert.assertTrue(Letter.isLetter('0'));
		Assert.assertFalse(Letter.isLetter('&'));
	}
	
	@Test
	public void testVowel() {
		Assert.assertTrue(Letter.vowel('�'));
		Assert.assertTrue(Letter.vowel('I'));
		Assert.assertFalse(Letter.vowel('c'));
	}
	
	@Test
	public void testStrongVowel() {
		Assert.assertTrue(Letter.strongVowel('�'));
		Assert.assertFalse(Letter.strongVowel('I'));
		Assert.assertFalse(Letter.strongVowel('c'));
	}
	
	@Test
	public void testWeakVowel() {
		Assert.assertFalse(Letter.weakVowel('�'));
		Assert.assertTrue(Letter.weakVowel('I'));
		Assert.assertFalse(Letter.weakVowel('c'));
	}
	
	@Test
	public void testConsonant() {
		Assert.assertTrue(Letter.consonant('x'));
		Assert.assertTrue(Letter.consonant('�'));
		Assert.assertFalse(Letter.consonant('a'));
	}
	
	@Test
	public void testAccent() {
		Assert.assertTrue(Letter.accent('�'));
		Assert.assertFalse(Letter.accent('�'));
		Assert.assertFalse(Letter.accent('a'));
	}
}
