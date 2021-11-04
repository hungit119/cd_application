package controller;

import java.util.ArrayList;
import java.util.List;

import model.CD;

public class ListCD {
	private ArrayList<CD> listCD;

	public ListCD() {
		this.listCD = new ArrayList<CD>();
	}

	public ArrayList<CD> getListCD() {
		return listCD;
	}

	public void setListCD(ArrayList<CD> listCD) {
		this.listCD = listCD;
	}

	public void addCD(CD cd) {
		this.listCD.add(cd);
		System.out.println("Da them cd");
	}

	public CD getCD(int i) {
		if (i < 0 || i > this.listCD.size()) {
			System.out.println("Khong ton tai cd nay");
			return null;
		} else {
			return listCD.get(i);
		}
	}

	public int deleteCD(int id) {
		boolean r = false;
		for (int i = 0; i < this.listCD.size(); i++) {
			if (this.listCD.get(i).getMaCD() == id) {
				this.listCD.remove(i);
				r = true;
				return i;
			}
		}
		if (r == false) {
			System.out.println("Khon ton tai cd co id nay");
		}
		return 0;
	}

	public CD searchCD(int id) {
		CD newCD = new CD();
		for (int i = 0; i < this.listCD.size(); i++) {
			if (this.listCD.get(i).getMaCD() == id) {
				newCD = this.listCD.get(i);
			}
		}
		return newCD;
	}

	public void updateCD(int id, String tuaCD, String caSi, int soBaiHat, float giaThanh) {
		for (int i = 0; i < this.listCD.size(); i++) {
			if (this.listCD.get(i).getMaCD() == id) {
				this.listCD.get(i).setTuaCD(tuaCD);
				this.listCD.get(i).setCaSi(caSi);
				this.listCD.get(i).setSoBaiHat(soBaiHat);
				this.listCD.get(i).setGiaThanh(giaThanh);
			}
		}
	}

	public int tongCD() {
		return this.listCD.size();
	}
}
