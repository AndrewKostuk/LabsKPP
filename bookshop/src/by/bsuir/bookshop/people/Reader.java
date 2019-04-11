package by.bsuir.bookshop.people;

import java.util.ArrayList;
import java.util.Random;

import by.bsuir.bookshop.book.Book;

public class Reader extends Human {
	public static final String GOOD_OPINION = "like";
	public static final String BAD_OPINION = "dislike";

	private int bookIndex;
	private Book readingBook;
	private Random random;
	private ArrayList<Book> readingList;

	public Reader(String s) {
		super(s);
		bookIndex = 0;
		readingBook = new Book(0, "");
		readingList = new ArrayList<>();
	}

	public Book getBook() {
		return readingBook;
	}

	public int getBookIndex() {
		return bookIndex;
	}

	public void read(Writer w) {
		readingList = w.getLiteratureList();
		random = new Random(System.currentTimeMillis());
		bookIndex = random.nextInt(readingList.size());
		readingBook = readingList.get(bookIndex);
	}

	public String giveOpinion() {
		if (random.nextInt(2) == 0) {
			return BAD_OPINION;
		} else
			return GOOD_OPINION;
	}
}