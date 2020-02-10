import java.util.*;


abstract class Animal {
  public void eat() {
    System.out.println("Animal Eating!");
  }
}

class Dog extends Animal {
  public void bark() {}
}

class Cat extends Animal {
  public void meow() {}
}

public class TestGenerics3 {
  public static void main(String[] args) {
    new TestGenerics3().go();
  }

  public void go() {
    ArrayList<Dog> animals = new ArrayList<Dog>();
    animals.add(new Dog());
    animals.add(new Dog());
    animals.add(new Dog());
    takeAnimals(animals);
  }

  public void takeAnimals(ArrayList<? extends Animal> animals) {
    for (Animal a : animals) {
      a.eat();
    }
  }
}