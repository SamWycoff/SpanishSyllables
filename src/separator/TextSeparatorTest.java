package separator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextSeparatorTest {

	@Test
	public void testSeparator() {
		String noSlashes = TextSeparator.separate("El le�n es un animal magn�fico");
		assertTrue(noSlashes.equals("'El.le.'�.'ne.'su.na.ni.'mal.mag.'n�.fi.co."));
		String oneSlash = TextSeparator.separate("El le�n es un animal magn�fico.");
		assertTrue(oneSlash.equals("'El.le.'�.'ne.'su.na.ni.'mal.mag.'n�.fi.co/"));
		String multipleSlashes = TextSeparator.separate("El le�n...es un animal magn�fico.");
		assertTrue(multipleSlashes.equals("'El.le.'�n/'e.'su.na.ni.'mal.mag.'n�.fi.co/"));
	}
	
	@Test
	public void testResyllabification() {
		String noPrevious = TextSeparator.resyllabification("", "co.mer.");
		String noPresent = TextSeparator.resyllabification("co.mer.", "");
		String periodSlash = TextSeparator.resyllabification("co.mer.", "/cho.co.la.te.");
		String slash = TextSeparator.resyllabification("co.mer/", "cho.co.la.te.");
		String accent = TextSeparator.resyllabification("co.mer.", "�r.bo.les.");
		String accentWithSlash = TextSeparator.resyllabification("co.mer.", "/�r.bo.les.");
		String consonantVowel = TextSeparator.resyllabification("co.mer.", "a.or.ta.");
		String consonantVowelStress = TextSeparator.resyllabification("co.mer.", "'es.");
		String other = TextSeparator.resyllabification("a.or.ta.", "co.mer.");
		assertTrue(noPrevious.equals("co.mer."));
		assertTrue(noPresent.equals("co.mer."));
		assertTrue(periodSlash.equals("co.mer/cho.co.la.te."));
		assertTrue(slash.equals("co.mer/cho.co.la.te."));
		assertTrue(accent.equals("co.mer.�r.bo.les."));
		assertTrue(accentWithSlash.equals("co.mer/�r.bo.les."));
		assertTrue(consonantVowel.equals("co.me.ra.or.ta."));
		assertTrue(consonantVowelStress.equals("co.me.'res."));
		assertTrue(other.equals("a.or.ta.co.mer."));
	}
}
