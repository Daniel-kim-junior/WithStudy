package day8;

abstract class Pet {
	public abstract void petSound();
// public으로 지정할 경우 자식 클래스에서도 public이 필수입니다.
	public void sleep() {
		System.out.println("Zzz");
	}
}

class Dog extends Pet {
	public void petSound() {
		System.out.println("멍멍!!");
	}
}

class Cat extends Pet {
	public void petSound() {
		System.out.println("야옹~~");
	}
}

public class PetTest {
	public static void main(String[] args) {
		actionPet(new Dog());
		actionPet(new Cat());
	}

	static void actionPet(Pet obj) {
		obj.petSound();
		obj.sleep();
	}
}
