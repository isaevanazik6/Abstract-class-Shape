import java.util.Scanner;

abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String name, double side1, double side2, double side3) {
        super(name);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

class Square extends Rectangle {
    public Square(String name, double sideLength) {
        super(name, sideLength, sideLength);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a shape (1-Rectangle, 2-Circle, 3-Triangle, 4-Square, 5-Exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            String shapeName;
            double dimension1, dimension2, dimension3;

            switch (choice) {
                case 1:
                    shapeName = "Rectangle";
                    System.out.print("Enter width: ");
                    dimension1 = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    dimension2 = scanner.nextDouble();
                    Shape rectangle = new Rectangle(shapeName, dimension1, dimension2);
                    displayShapeInfo(rectangle);
                    break;
                case 2:
                    shapeName = "Circle";
                    System.out.print("Enter radius: ");
                    dimension1 = scanner.nextDouble();
                    Shape circle = new Circle(shapeName, dimension1);
                    displayShapeInfo(circle);
                    break;
                case 3:
                    shapeName = "Triangle";
                    System.out.print("Enter side 1: ");
                    dimension1 = scanner.nextDouble();
                    System.out.print("Enter side 2: ");
                    dimension2 = scanner.nextDouble();
                    System.out.print("Enter side 3: ");
                    dimension3 = scanner.nextDouble();
                    Shape triangle = new Triangle(shapeName, dimension1, dimension2, dimension3);
                    displayShapeInfo(triangle);
                    break;
                case 4:
                    shapeName = "Square";
                    System.out.print("Enter side length: ");
                    dimension1 = scanner.nextDouble();
                    Shape square = new Square(shapeName, dimension1);
                    displayShapeInfo(square);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid shape.");
                    break;
            }
        }
    }

    private static void displayShapeInfo(Shape shape) {
        System.out.println("Shape: " + shape.getName());
        System.out.println("Area: " + shape.getArea());
        System.out.println("Perimeter: " + shape.getPerimeter());
    }
}

