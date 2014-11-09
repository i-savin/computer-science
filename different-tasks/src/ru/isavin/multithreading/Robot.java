package ru.isavin.multithreading;

/**
 * Задача на собеседовании в Яндекс была у Бахтиарова.
 * Я так понял, нужно сделать многопоточного робота,
 * чтобы он шагал по очереди правой и левой ногами, 
 * в разных потоках. Это я и реализовал
 * @author ilasavin
 *
 */
public class Robot {
	/**
	 * Флаг того, что был сделан шаг правой ногой
	 */
	private boolean rightStepWasMade;
	/**
	 * Скорость, шаг в секунду
	 */
	private float speed;
	
	public Robot(float speed) {
		this.speed = speed;
	}

	/**
	 * Пока не был сделан шаг левой ногой 
	 * (т.е. rightStepWasMade = true), этот поток
	 * ждет. Получив уведомление о том, что шаг левой
	 * ногой был сделан (от потока, отвечающего за
	 * левую ногу), делает свой шаг, выжидает
	 * время, зависящее от скорости ходьбы, и оповещает
	 * второй поток
	 */
	private synchronized void makeRightStep() {
		while (rightStepWasMade) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Робот делает шаг правой ногой");
		try {
			Thread.sleep(Math.round(1 * 1000L / speed));
		} catch (InterruptedException e) {
		}
		rightStepWasMade = true;
		notify();
	}

	/**
	 * Пока не был сделан шаг правой ногой 
	 * (т.е. rightStepWasMade = false), этот поток
	 * ждет. Получив уведомление о том, что шаг правой
	 * ногой был сделан (от потока, отвечающего за
	 * правую ногу), делает свой шаг, выжидает
	 * время, зависящее от скорости ходьбы, и оповещает
	 * второй поток
	 */
	private synchronized void makeLeftStep() {
		while (!rightStepWasMade) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Робот делает шаг левой ногой");
		try {
			Thread.sleep(Math.round(1 * 1000L / speed));
		} catch (InterruptedException e) {
		}
		rightStepWasMade = false;
		notify();
	}

	/**
	 * В двух потоках запускает бесконечный цикл 
	 * шагов поочередно правой и левой ногами
	 */
	public void go() {
		Thread rightStep = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					makeRightStep();
				}
			}
		});

		Thread leftStep = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					makeLeftStep();
				}
			}
		});
		
		rightStep.start();
		leftStep.start();
	}
	
	public static void main(String[] args) {
		Robot robot = new Robot(0.5f);
		robot.go();
	}

}
