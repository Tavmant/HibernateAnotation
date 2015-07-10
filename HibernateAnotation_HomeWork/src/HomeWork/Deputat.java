package HomeWork;

import java.util.Scanner;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Deputat extends Person {
	@Column
	private String lastName;
	@Column
	private String firstName;
	@Column
	private int age;
	@Column
	private boolean briberTaken;
	@Column
	private int bribes;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fractionId")
	private Fraction fraction;

	public Deputat() {
		
	}

	public Deputat(double weight, double height, String lastName,
			String firstName, int age, boolean briberTaken, Fraction fraction) {
		super(weight, height);
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.briberTaken = briberTaken;
		this.bribes = 0;
		this.fraction = fraction;

	}
	
	//Constructor for default database
	public Deputat(double weight, double height, String lastName,
			String firstName, int age, int bribes, Fraction fraction) {
		super(weight, height);
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.briberTaken = true;
		this.bribes = bribes;
		this.fraction = fraction;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBriberTaken() {
		return briberTaken;
	}

	public void setBriberTaken(boolean briberTaken) {
		this.briberTaken = briberTaken;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	@Override
	public String toString() {
		return "Surname= " + lastName + ", Name= " + firstName
				+ ", Age= " + age + ", Bribe-taker= " + briberTaken
				+ ", Bribe= " + bribes + ", " + super.toString() + "\n";
	}

	public void GiveBrakes() {
		if (!briberTaken) {
			System.out.println("\nThis deputy did not take bribes!");
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.print("\nEnter the amount of bribe: ");
			int br = sc.nextInt();
			if (br > 5000) {
				System.out.println("\nPolice arrested the deputy!");
				this.bribes = br;
			} else {
				if (br < 0) {
					System.out.println("\nGrafter doesn't give back money!");
				} else {
					this.bribes = br;
				}
			}
		}
	}

	public int getBribes() {
		return bribes;
	}
}
