package by.bsuir.bookshop.book;

public class Recense extends Book {
	private String recense;

	public Recense(int p, String s, String r) {
		super(p, s);
		recense = new String(r);
	}

	public String getRecense() {
		return recense;
	}

	public void setRecense(String r) {
		recense = r;
	}
}