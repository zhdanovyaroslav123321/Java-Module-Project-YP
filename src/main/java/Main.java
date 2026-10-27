import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Race race = new Race();

        String name = "";
        int speed;

        for (int i = 1; i <= 3; i++) {

            while (true) {
                System.out.println("— Введите название машины №" + i + ":");
                name = scanner.nextLine();                                          //читаем через nextLine чтобы учесть возможный пустой ввод
                System.out.println("\n");
                if (!name.trim().isEmpty()) {
                    break;
                }
                System.out.println("— Неправильное название\n");
            }

            while (true) {
                System.out.println("— Введите скорость машины №" + i + ":");
                String strSpeed = scanner.nextLine().trim();
                System.out.println("\n");
                boolean isInt = strSpeed.matches("-?\\d+");
                if (isInt) {
                    speed = Integer.parseInt(strSpeed);
                    if (speed > 0 && speed <= 250) {
                        break;
                    }
                }
                System.out.println("— Неправильная скорость\n");
            }
            Car newCar = new Car(name, speed);
            race.checkDist(newCar);
        }

        System.out.println("Самая быстрая машина: " + race.leader);

        scanner.close();
    }
}

class Car {
    String name;
    int speed;
    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {
    String leader = "";
    int maxDist;
    void checkDist(Car other) {
        int otherDist = other.speed * 24;
        if (otherDist > maxDist){
            maxDist = otherDist;
            leader = other.name;
        }
    }
}