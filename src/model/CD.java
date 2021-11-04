package model;

public class CD {
	private int maCD;
	private String tuaCD;
	private String caSi;
	private int soBaiHat;
	private float giaThanh;
	
	public CD() {
		super();
	}

	public CD(int maCD, String tuaCD, String caSi, int soBaiHat, float giaThanh) {
		super();
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.caSi = caSi;
		this.soBaiHat = soBaiHat;
		this.giaThanh = giaThanh;
	}

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}

	public String getCaSi() {
		return caSi;
	}

	public void setCaSi(String caSi) {
		this.caSi = caSi;
	}

	public int getSoBaiHat() {
		return soBaiHat;
	}

	public void setSoBaiHat(int soBaiHat) {
		this.soBaiHat = soBaiHat;
	}

	public float getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(float giaThanh) {
		this.giaThanh = giaThanh;
	}
	public int equalCDById(int b) {
		int result = 0;
		if (this.maCD == b) {
			result = 1;
		}
		return result;
	}
	@Override
	public String toString() {
		return "CD [maCD=" + maCD + ", tuaCD=" + tuaCD + ", caSi=" + caSi + ", soBaiHat=" + soBaiHat + ", giaThanh="
				+ giaThanh + "]";
	}
}
