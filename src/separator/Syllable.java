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
		syllable = "'" + syllable;
	}
}
