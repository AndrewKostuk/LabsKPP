package by.bsuir.lift_and_people.human;

import java.util.Random;

import by.bsuir.lift_and_people.lift.Lift;

public class Human extends Thread {
	public static final int MAX_FLOOR = 10;

	private final Object lock = new Object();

	private Lift lift;

	private int targetFloor;
	private int currentFloor;

	private Random random;

	public Human(Lift l) {
		random = new Random(System.currentTimeMillis());
		currentFloor = random.nextInt(MAX_FLOOR) + 1; // задать текущий этаж
		do {
			targetFloor = random.nextInt(MAX_FLOOR) + 1; // задать этаж назначения (не совпадает с текущим этожом)
		} while (targetFloor == currentFloor);
		lift = l;
	}

	public boolean checkLiftCapacity() {
		if (lift.getPassengers().size() < 5)
			return true; // если пассажиров меньше 5, то можно войти
		else
			return false; // иначе войти нельзя
	}

	public void waitForElevator() {
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void trip() {
		lift.getPassengers().add(this); // то добаваляем его в список пассажиров
		int changeIndex = lift.getWaitingQueue().indexOf(this); // индекс для зануления человека в очереди
		lift.getWaitingQueue().set(changeIndex, null);
		lift.setCallArray(targetFloor); // выбрать этаж назначения
		do {
			waitForElevator();// ждем пока приедем на нужный этаж
		} while (lift.getFloor() != targetFloor);
		lift.getPassengers().remove(this); // выходим из лифта
	}

	public void callElevator() {
		lift.setCallArray(currentFloor); // вызов лифта на текущий этаж
		lift.getWaitingQueue().add(this); // добавиться в очередь
	}

	@Override
	public void run() {
		callElevator();
		while (true) {
			do {
				waitForElevator();// ждать пока приедет лифт
			} while (lift.getFloor() != currentFloor);

			boolean choose = checkLiftCapacity();
			if (choose == true) { // если человек решил войти в лифт
				trip(); // то поездка
				return;
			}
		}
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getTargetFloor() {
		return targetFloor;
	}

	public Object getLock() {
		return lock;
	}
}