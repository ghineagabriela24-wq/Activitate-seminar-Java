public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(10);

        Vehicle car1 = new Car("C1", "BMW", 220, 9000, 4);
        Vehicle car2 = new Car("C2", "Audi", 210, 12000, 2);
        Vehicle moto1 = new Motorcycle("M1", "Yamaha", 180, 5000, false);
        Vehicle moto2 = new Motorcycle("M2", "Honda", 160, 7000, true);
        Vehicle truck1 = new Truck("T1", "Volvo", 130, 16000, 10000);

        garage.add(car1);
        garage.add(car2);
        garage.add(moto1);
        garage.add(moto2);
        garage.add(truck1);

        Vehicle[] vehicles = {car1, car2, moto1, moto2, truck1};

        System.out.println("Polymorphism demonstration:");

        for (Vehicle v : vehicles) {
            v.move();
        }

        Car c1 = new Car("C10", "Dacia", 170, 3000, 4);
        Car c2 = new Car("C10", "Dacia", 170, 3000, 4);

        System.out.println("\nAre the two cars equal? " + c1.equals(c2));

        garage.rentById("C1");
        garage.rentById("M2");

        garage.printAvailable();

        garage.printNeedsService();

        garage.printRentalEstimate("C1", 3);
        garage.printRentalEstimate("M2", 3);
        garage.printRentalEstimate("T1", 3);

        garage.returnById("C1", 500);

        garage.printAvailable();
    }
}