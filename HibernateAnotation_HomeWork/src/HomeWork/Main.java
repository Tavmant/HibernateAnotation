package HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

public class Main {
	static void menu() {
		System.out.println("\n----------------------"
				+ "\nВведіть 1 щоб додати фракцію"
				+ "\nВведіть 2 щоб видалити фракцію"
				+ "\nВведіть 3 щоб очистити фракцію"
				+ "\nВведіть 4 щоб вивести фракції"
				+ "\nВведіть 5 щоб вивести фракцію"
				+ "\nВведіть 6 щоб додати депутата в фракцію"
				+ "\nВведіть 7 щоб видалити депутата з фракції "
				+ "\nВведіть 8 щоб вивести список хабарників "
				+ "\nВведіть 9 щоб вивести найбільшого хабарника"
				+ "\nВведіть 0 щоб вийти з програми");
	}
	
	static List<Fraction> defaultFractions() {
		List<Fraction> fraction = new ArrayList<>();
		
		List<Deputat> deputat1 = new ArrayList<>();	
		fraction.add(new Fraction("Freedom", deputat1));
		deputat1.add(new Deputat(90.4, 1.8, "Tigipko", "Andrew", 45, false, fraction.get(0)));
		deputat1.add(new Deputat(110.1, 1.6, "Pupkin", "Petro", 28, 2500, fraction.get(0)));
		fraction.get(0).setList(deputat1);
		
		List<Deputat> deputat2 = new ArrayList<>();
		fraction.add(new Fraction("Regions", deputat2));
		deputat2.add(new Deputat(102.9, 1.9, "Janukovych", "Viktor", 52, 8000, fraction.get(1)));
		deputat2.add(new Deputat(60.2, 1.8, "Shufrych", "Nestor", 51, 3700, fraction.get(1)));
		fraction.get(1).setList(deputat2);
		
		List<Deputat> deputat3 = new ArrayList<>();
		fraction.add(new Fraction("Homeland", deputat3));
		deputat3.add(new Deputat(61.0, 1.65, "Tymoshenko", "Yulia", 41, false, fraction.get(2)));
		deputat3.add(new Deputat(72.3, 1.87, "Yatsenjuk", "Arsenij", 47, false, fraction.get(2)));
		fraction.get(2).setList(deputat3);
		
		return fraction;
	}

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		MainRadaDao rada = new MainRadaDao();
		try {
			while (true) {
				Scanner sc = new Scanner(System.in);
				menu();
				switch (sc.nextInt()) {
				case 1: {
					rada.addFraction();
					break;
				}
				case 2: {
					rada.removeFraction();
					break;
				}
				case 3: {
					rada.clearFraction();
					break;
				}
				case 4: {
					rada.printAllFractions();
					break;
				}
				case 5: {
					rada.printFraction();
					break;
				}
				case 6: {
					rada.addDeputat();
					break;
				}
				case 7: {
					rada.removeDeputat();
					break;
				}
				case 8: {
					rada.printAllBraberTakers();
					break;
				}
				case 9: {
					rada.printMaxBraberTaker();
					break;
				}
				case 0: {
					HibernateUtils.shutdown();
					System.exit(1);
					break;
				}
				default: {
					rada.resetDataBaseToDefault(defaultFractions());
				}
				}
			}
		} catch (Exception e) {
			System.err.println("Перезапустіть програму.");
		}
	}
}
