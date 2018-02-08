package separator;

public class Syllable {
	private String syllable;
	
	public Syllable (String syllable) {
		this.syllable = syllable;
	}
	
	public String getSyllable() {
		return syllable;
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
