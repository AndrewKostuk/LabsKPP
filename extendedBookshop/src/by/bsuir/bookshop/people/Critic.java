package by.bsuir.bookshop.people;

import java.util.ArrayList;
import java.util.Random;

import by.bsuir.bookshop.book.Recense;

public class Critic extends Reader {
	private static final String GOOD_RECENSE = "good";
	private static final String BAD_RECENSE = "bad";

	private ArrayList<Recense> recenseList;
	private Random random;
	private Recense newRecense;
	private int bookNumber;
	private int bookPages;

	public Critic(String s) {
		super(s);
		newRecense = new Recense(0, "", "");
		bookNumber = 1;
		bookPages = 0;
	}

	public void writeRecense() {
		readingList = insideWriter.getLiteratureList();
		recenseList = new ArrayList<Recense>(readingList.size());
		random = new Random(System.currentTimeMillis());
		// для каждой книги написать рецензию
		for (int i = 0; i < readingList.size(); i++) {
			bookPages = random.nextInt(41) + 10; // число страниц от 10 до 50
			if (random.nextInt(2) == 0)// 0 - good, 1 - bad
				newRecense = new Recense(bookPages, "book" + bookNumber, GOOD_RECENSE);
			else
				newRecense = new Recense(bookPages, "book" + bookNumber, BAD_RECENSE);
			recenseList.add(newRecense);
			bookNumber++;
		}
	}

	public ArrayList<Recense> getRecenseList() {
		return recenseList;
	}
}
