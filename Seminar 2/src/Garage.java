public class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        fleet = new Vehicle[capacity];
        size = 0;
    }

    public void add(Vehicle v) {
        if (size == fleet.length) {
            throw new IllegalStateException("Garage is full.");
        }

        if (findById(v.getId()) != null) {
            throw new IllegalArgumentException("Duplicate vehicle ID: " + v.getId());
        }

        fleet[size] = v;
        size++;
    }

    public Vehicle findById(String id) {
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(id)) {
                return fleet[i];
            }
        }

        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);

        if (v == null) {
            throw new IllegalArgumentException("Vehicle not found.");
        }

        v.rent();
        System.out.println("Vehicle " + id + " was rented.");
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);

        if (v == null) {
            throw new IllegalArgumentException("Vehicle not found.");
        }

        v.returnVehicle(drivenKm);
        System.out.println("Vehicle " + id + " was returned.");
    }

    public void printAvailable() {
        System.out.println("\nAvailable vehicles:");

        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) {
                System.out.println(fleet[i]);
            }
        }
    }

    public void printNeedsService() {
        System.out.println("\nVehicles that need service:");

        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) {
                System.out.println(fleet[i]);
            }
        }
    }

    public void printRentalEstimate(String id, int days) {
        Vehicle v = findById(id);

        if (v == null) {
            throw new IllegalArgumentException("Vehicle not found.");
        }

        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than 0.");
        }

        System.out.println("\nRental estimate for vehicle " + id + ": " + v.rentalPrice(days));
    }
}