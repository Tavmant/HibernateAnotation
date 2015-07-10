package HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRada {
	private List<Fraction> list;

	public MainRada(List<Fraction> list) {
		this.list = list;
	}

	public Fraction addFraction() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the fraction: ");
		Fraction frac = new Fraction(myUpperCase(sc.nextLine()));
		for (Fraction f : list) {
			if (f.getName().equalsIgnoreCase(frac.getName())) {
				throw new IllegalArgumentException("This fraction already exist!");
			}
		}
		return frac;
	}

	public Fraction removeFraction() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the fraction: ");
		String tmp = sc.nextLine();
		for (Fraction frac : list) {
			if (frac.getName().equalsIgnoreCase(tmp)) {
				return frac;
			}
		}
		throw new IllegalArgumentException("This fraction doesn't exists.");
	}

	public void printAllFractions() {
		for (Fraction frac : list) {
			System.out.println("\n" + frac.getName());
			for (Deputat dep : frac.getList()) {
				System.out.print(dep);
			}
		}
	}

	public void printFraction() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the fraction: ");
		String tmp = sc.nextLine();
		boolean myCheck = false;
		for (Fraction frac : list) {
			if (frac.getName().equalsIgnoreCase(tmp)) {
				System.out.println(frac.getName());
				frac.printAllDeputats();
				myCheck = true;
			}
		}
		if(!myCheck) {
			throw new IllegalArgumentException("This fraction doesn't exists.");
		}
	}

	public Fraction addDeputat() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the fraction: ");
		String tmp = sc.nextLine();
		for (Fraction frac : list) {
			if (frac.getName().equalsIgnoreCase(tmp)) {
				frac.addDeputat();
				return frac;
			}
		}
		throw new IllegalArgumentException("This fraction doesn't exists.");
	}

	public int removeDeputat() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the fraction: ");
		String tmp = sc.nextLine();
		for (Fraction frac : list) {
			if (frac.getName().equalsIgnoreCase(tmp)) {
				return frac.removeDeputat();
			}
		}
		throw new IllegalArgumentException("This fraction doesn't exists.");
	}

	public void printAllBraberTakers() {
		for (Fraction frac : list) {
			frac.printBraberTakers();
		}
	}

	public void printMaxBraberTaker() {
		for (Fraction frac : list) {
			frac.printMaxBraberTaker();
		}
	}

	public Fraction clearFraction() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the fraction: ");
		String tmp = sc.nextLine();
		for (Fraction frac : list) {
			if (frac.getName().equalsIgnoreCase(tmp)) {
				return frac;
			}
		}
		throw new IllegalArgumentException("This fraction doesn't exists.");
	}
	
	private String myUpperCase(String s) {
		String s2 = s.substring(0, 1).toUpperCase();
		s = s.substring(1).toLowerCase();
		return s2.concat(s);
	}

	public List<Fraction> getList() {
		return list;
	}
}
