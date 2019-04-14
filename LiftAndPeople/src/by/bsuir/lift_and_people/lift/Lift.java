package by.bsuir.lift_and_people.lift;

import java.util.ArrayList;
import java.util.List;

import by.bsuir.lift_and_people.human.Human;

public class Lift extends Thread {
	private static final int MAX_FLOOR = 10;
	private static final int MIN_FLOOR = 1;

	private List<Object> lock; // нужен для синхронизации

	private List<Human> passengers;
	private List<Human> waitingQueue;

	private int[] callArray = new int[MAX_FLOOR + 1]; // хранит вызовы от ожидающих на каждом этаже изначально
														// обнулен (никто не вызвал лифт)
	private int floor;
	private boolean goOn = false; // следует ли двигаться лифту

	public Lift() {
		lock = new ArrayList<>();
		passengers = new ArrayList<>();
		waitingQueue = new ArrayList<>();
	}

	public void goUp() {
		try {
			sleep(2000);// go up for 2 seconds
		} catch (InterruptedException e) {
		}
		floor++;
	}

	public void goDown() {
		try {
			sleep(2000);// go down for 2 seconds
		} catch (InterruptedException e) {
		}
		floor--;
	}

	public void enterExit() {
		for (Object o : lock) {
			synchronized (o) {
				o.notify(); // сообщить каждому ожидающему о прибытии на этаж
			}
		}
		resetCallArray(floor); // снять вызов этого этажа
	}

	public void checkCallArray() {
		goOn = false;
		for (int i : callArray) {
			if (i != 0)
				goOn = true; // продолжить движение лифта если кто-то его вызвал
		}
	}

	@Override
	public void run() {
		while (true) {
			checkCallArray(); // вызывали ли лифт?
			if (goOn == false)
				return;

			while (floor != MAX_FLOOR) {
				goUp();
				if (callArray[floor] == 1) // если прибыли на этаж, который кто-то вызвал
					enterExit();
			}

			while (floor != MIN_FLOOR) {
				goDown();
				if (callArray[floor] == 1)
					enterExit();
			}
		}
	}

	public void resetCallArray(int i) {
		callArray[i] = 0;
	}

	public void setCallArray(int i) {
		callArray[i] = 1;
	}

	public int getFloor() {
		return floor;
	}

	public List<Human> getPassengers() {
		return passengers;
	}

	public List<Human> getWaitingQueue() {
		return waitingQueue;
	}

	public void setLock(Object l) {
		lock.add(l);
	}
}