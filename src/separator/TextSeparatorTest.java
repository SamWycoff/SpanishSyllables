package separator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextSeparatorTest {

	@Test
	public void testSeparator() {
		String noSlashes = TextSeparator.separate("El león es un animal magnífico");
		assertTrue(noSlashes.equals("'El.le.'ó.'ne.'su.na.ni.'mal.mag.'ní.fi.co."));
		String oneSlash = TextSeparator.separate("El león es un animal magnífico.");
		assertTrue(oneSlash.equals("'El.le.'ó.'ne.'su.na.ni.'mal.mag.'ní.fi.co/"));
		String multipleSlashes = TextSeparator.separate("El león...es un animal magnífico.");
		assertTrue(multipleSlashes.equals("'El.le.'ón/'e.'su.na.ni.'mal.mag.'ní.fi.co/"));
	}
	
	@Test
	public void testResyllabification() {
		String noPrevious = TextSeparator.resyllabification("", "co.mer.");
		String noPresent = TextSeparator.resyllabification("co.mer.", "");
		String periodSlash = TextSeparator.resyllabification("co.mer.", "/cho.co.la.te.");
		String slash = TextSeparator.resyllabification("co.mer/", "cho.co.la.te.");
		String accent = TextSeparator.resyllabification("co.mer.", "ár.bo.les.");
		String accentWithSlash = TextSeparator.resyllabification("co.mer.", "/ár.bo.les.");
		String consonantVowel = TextSeparator.resyllabification("co.mer.", "a.or.ta.");
		String consonantVowelStress = TextSeparator.resyllabification("co.mer.", "'es.");
		String other = TextSeparator.resyllabification("a.or.ta.", "co.mer.");
		assertTrue(noPrevious.equals("co.mer."));
		assertTrue(noPresent.equals("co.mer."));
		assertTrue(periodSlash.equals("co.mer/cho.co.la.te."));
		assertTrue(slash.equals("co.mer/cho.co.la.te."));
		assertTrue(accent.equals("co.mer.ár.bo.les."));
		assertTrue(accentWithSlash.equals("co.mer/ár.bo.les."));
		assertTrue(consonantVowel.equals("co.me.ra.or.ta."));
		assertTrue(consonantVowelStress.equals("co.me.'res."));
		assertTrue(other.equals("a.or.ta.co.mer."));
	}
}
