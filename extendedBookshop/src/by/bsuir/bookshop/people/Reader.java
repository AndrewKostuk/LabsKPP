package by.bsuir.bookshop.people;

import java.util.ArrayList;
import java.util.Random;

import by.bsuir.bookshop.book.Book;

public class Reader extends Human {
	private final static String GOOD_OPINION = "like";
	private final static String BAD_OPINION = "dislike";

	private int bookIndex;
	private Book readingBook;
	private Random random;
	protected ArrayList<Book> readingList;
	protected Writer insideWriter;

	public Reader(String s) {
		super(s);
		bookIndex = 0;
		readingBook = new Book(0, "");
		readingList = new ArrayList<>();
		insideWriter = new Writer("");
	}

	public Book getBook() {
		return readingBook;
	}

	public int getBookIndex() {
		return bookIndex;
	}

	public void setWriter(Writer w) {
		insideWriter = w;
	}

	public void read() {
		readingList = insideWriter.getLiteratureList();
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