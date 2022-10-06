import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Human {
    public String name;
    public String surname;
    public int age;

    Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(name, human.name) && Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}

public class StreamAPI {
    public static void Init(ArrayList<Human> arr) {
        arr.add(new Human("Oleg", "Smirnov", 28));
        arr.add(new Human("Maksim", "Petrov", 20));
        arr.add(new Human("Ruslan", "Sokolov", 30));
        arr.add(new Human("Artem", "Popov", 35));
        arr.add(new Human("Daniil", "Belkin", 44));
        arr.add(new Human("Olga", "Volkova", 20));
        arr.add(new Human("Mikhail", "Lebedev", 22));
    }
    public static void Stream1() {
        ArrayList<Integer> arr = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++)
            arr.add(rand.nextInt() % 100);
        System.out.println(arr.stream().filter(x -> x%2 == 0).count()); // вывод четных чисел
    }
    public static void Stream2() {
        ArrayList <Human> arr = new ArrayList<>();
        Init(arr);
        arr.stream().sorted(Comparator.comparing(Human::getAge)).map(Human::getAge).forEach(System.out::println);
    }
    public static void Stream3() {
        ArrayList <Human> arr = new ArrayList<>();
        Init(arr);
        arr.stream().map(Human::getName).filter(x -> x.charAt(0) == 'M').forEach(System.out::println);
    }
    public static void main(String[] args) {
        System.out.println("Stream1");
        Stream1();
        System.out.println("Stream2");
        Stream2();
        System.out.println("Stream3");
        Stream3();
    }
}
