package Homework2;

public class App {
public static void main(String[] args) {
    Product apple = new Product();
    apple.setId(1);
    apple.setName("Яблоко");
    apple.setPrice(100);
    apple.setCount(5);
    System.out.println(apple.toString());

    Product water = new Product(2, "вода", 50, 2);
    Product lemon = new Product(3, "лимон", 135, 3);
    System.out.println(water.toString() + "\n" + lemon.toString());

}
}
