public abstract class Vehicle {
    private String id;
    private String brand;
    private double speed;
    private int mileage;
    private boolean rented;

    public Vehicle(String id, String brand, double speed, int mileage) {
        this.id = id;
        this.brand = brand;
        this.speed = speed;
        this.mileage = mileage;
        this.rented = false;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getSpeed() {
        return speed;
    }

    public int getMileage() {
        return mileage;
    }

    public boolean isRented() {
        return rented;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void rent() {
        if (rented) {
            throw new IllegalStateException("Vehicle is already rented.");
        }

        rented = true;
    }

    public void returnVehicle(int drivenKm) {
        if (!rented) {
            throw new IllegalStateException("Vehicle is not rented.");
        }

        if (drivenKm <= 0) {
            throw new IllegalArgumentException("Driven kilometers must be greater than 0.");
        }

        mileage += drivenKm;
        rented = false;
    }

    public abstract void move();

    public abstract boolean needsService();

    public abstract double rentalPrice(int days);

    @Override
    public String toString() {
        return "ID: " + id +
                ", Brand: " + brand +
                ", Speed: " + speed +
                " km/h, Mileage: " + mileage +
                ", Rented: " + rented;
    }
}