package by.bsuir.bookshop.people;

import java.util.ArrayList;
import java.util.Random;

import by.bsuir.bookshop.book.Book;

public class Writer extends Human {

	private ArrayList<Book> literatureList;
	private int bookNumber;
	private int bookPages;
	private Book newBook;
	private Random random;

	public Writer(String s) {
		super(s);
		literatureList = new ArrayList<>();
		bookNumber = 1;
		bookPages = 0;
		newBook = new Book(0, "");
	}

	public Writer(Writer w) {
		super(w.name);
		this.literatureList = new ArrayList<Book>(w.literatureList);
		this.bookNumber = w.bookNumber;
		this.bookPages = w.bookPages;
		this.newBook = new Book(w.newBook);
		this.random = new Random(System.currentTimeMillis());
	}

	public void writeBook() {
		random = new Random(System.currentTimeMillis());
		bookPages = random.nextInt(401) + 100; //число страниц от 100 до 500
		newBook = new Book(bookPages, "book" + bookNumber);
		literatureList.add(newBook);
		bookNumber++;
	}

	public ArrayList<Book> getLiteratureList() {
		return literatureList;
	}

	public void setOpinion(String opinion, int index) {
		literatureList.get(index).addOpinion(opinion);
	}

}