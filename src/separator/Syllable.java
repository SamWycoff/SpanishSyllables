package separator;

public class Syllable {
	private String syllable;
	
	public Syllable (String syllable) {
		this.syllable = syllable;
	}
	
	public String getSyllable() {
		return syllable;
	}
	
	public boolean isAccented() {
		for (int i = 0; i < syllable.length(); i++) {
			if (Letter.accent(syllable.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public void setStressed() {
		if (syllable.charAt(0) != '/') {
			syllable = "'" + syllable;
		}
		else {
			syllable = syllable.substring(0, 1) + "'" + syllable.substring(1);
		}
	}
}
