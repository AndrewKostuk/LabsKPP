package by.bsuir.bookshop.people;

import java.util.ArrayList;
import java.util.Random;

import by.bsuir.bookshop.book.Book;
import by.bsuir.bookshop.book.Novel;
import by.bsuir.bookshop.book.Recense;
import by.bsuir.bookshop.book.Story;

public class Writer extends Human {

	private ArrayList<Book> literatureList;
	private int bookNumber;
	private int bookPages;
	private Book newBook;
	private Random random;
	private Critic insideCritic;
	private ArrayList<Recense> recenceList;
	private int recenseIndex;
	private Recense recenseBook;

	public Writer(String s) {
		super(s);
		literatureList = new ArrayList<>();
		bookNumber = 1;
		bookPages = 0;
		newBook = new Book(0, "");

	}

	public void setCritic(Critic c) {
		insideCritic = c;
	}

	public Writer(Writer w) {
		super(w.name);
		this.literatureList = new ArrayList<Book>(w.literatureList);
		this.bookNumber = w.bookNumber;
		this.bookPages = w.bookPages;
		this.newBook = new Book(w.newBook);
		this.random = new Random(System.currentTimeMillis());
	}

	public void read() {
		recenceList = insideCritic.getRecenseList();
		random = new Random(System.currentTimeMillis());
		recenseIndex = random.nextInt(recenceList.size());
		recenseBook = recenceList.get(recenseIndex);
	}

	public void writeBook() {
		random = new Random(System.currentTimeMillis());
		bookPages = random.nextInt(401) + 100; // число страниц от 100 до 500
		if (random.nextInt(2) == 0)// 0 - Novel, 1 - Story
			newBook = new Novel(bookPages, "book" + bookNumber);
		else
			newBook = new Story(bookPages, "book" + bookNumber);
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
