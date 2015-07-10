package HomeWork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fraction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id = 0;
	@Column
	private String name;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fraction")
	private List<Deputat> list = new ArrayList<>();
	
	public Fraction() {
		//NON
	}

	public Fraction(String name) {
		this.name = name;
	}
	
	public Fraction(String name, List<Deputat> deputat) {
		this.name = name;
		this.list = deputat;
	}

	public void setList(List<Deputat> list) {
		this.list = list;
	}

	public List<Deputat> getList() {
		return list;
	}

	public String getName() {
		return name;
	}

	public void addDeputat() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter deputy:");
		System.out.print("Surname= ");
		String lastName = myUpperCase(sc.nextLine());
		System.out.print("Name= ");
		String firstName = myUpperCase(sc.nextLine());
		for (Deputat deputat : list) {
			if (deputat.getLastName().equalsIgnoreCase(lastName)
					&& deputat.getFirstName().equalsIgnoreCase(firstName)) {
				throw new IllegalArgumentException("This deputat already exist!");
			}
		}
		System.out.print("Weight= ");
		double weight = sc.nextDouble();
		System.out.print("Height= ");
		double height = sc.nextDouble();
		System.out.print("Age= ");
		int age = sc.nextInt();
		System.out.print("Is he bribe-taker?(true/false)= ");
		boolean briberTaken = false;
		boolean tmp = sc.nextBoolean();
		if (tmp) {
			briberTaken = true;
		}
		Deputat d = new Deputat(weight, height, lastName, firstName, age,
				briberTaken, this);
		d.GiveBrakes();
		list.add(d);
	}

	public void removeDeputat() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter deputy for expulsion: ");
		System.out.print("Surname= ");
		String lastName = sc.nextLine();
		System.out.print("Name= ");
		String firstName = sc.nextLine();
		Iterator<Deputat> iter = list.iterator();
		while (iter.hasNext()) {
			Deputat dep = iter.next();
			if (dep.getLastName().equalsIgnoreCase(lastName)
					&& dep.getFirstName().equalsIgnoreCase(firstName)) {
				iter.remove();
			}
		}
	}

	public void printBraberTakers() {
		boolean tmp = false;
		System.out.println(this.name);
		for (Deputat dep : list) {
			if (dep.isBriberTaken()) {
				tmp = true;
				System.out.println(dep);
			}
		}
		if (!tmp) {
			System.out.println("\nNo one deputy in this fraction don't take bribes!");
		}
	}

	public void printMaxBraberTaker() {
		Deputat maxBribe = list.get(0);
		for (Deputat dep : list) {
			if (dep.getBribes() > maxBribe.getBribes()) {
				maxBribe = dep;
			}
		}
		if (maxBribe.isBriberTaken()) {
			System.out.println("\nThe largest bribe-taker in fraction " 
					+ this.name + ": \n"  + maxBribe);
		} else {
			System.out.println("\nNo one deputy in fraction "
					+ this.name + " don't take bribes!");
		}
	}

	public void printAllDeputats() {
		for (Deputat dep : list) {
			System.out.println(dep);
		}
	}
	
	private String myUpperCase(String s) {
		String s2 = s.substring(0, 1).toUpperCase();
		s = s.substring(1).toLowerCase();
		return s2.concat(s);
	}
}
