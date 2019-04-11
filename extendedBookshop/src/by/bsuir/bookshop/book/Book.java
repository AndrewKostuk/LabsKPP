package by.bsuir.bookshop.book;

import java.util.ArrayList;

public class Book {

	private int pages;
	private String bookName;
	private ArrayList<String> opinionList;

	public Book(int p, String n) {
		pages = p;
		bookName = n;
		opinionList = new ArrayList<>();
	}

	public Book(Book b) {
		this.pages = b.pages;
		this.bookName = new String(b.getName());
		this.opinionList = b.getOpinions();
	}

	public String getName() {
		return bookName;
	}

	public void setName(String n) {
		bookName = n;
	}

	public void setPages(int p) {
		pages = p;
	}

	public void addOpinion(String o) {
		opinionList.add(o);
	}

	public ArrayList<String> getOpinions() {
		return opinionList;
	}
}