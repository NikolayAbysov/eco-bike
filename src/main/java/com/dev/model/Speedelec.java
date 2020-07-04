package com.dev.model;

public class Speedelec extends Bike {
    private int maxSpeed;
    private int batteryCapacity;

    public Speedelec(boolean isLoadedFromFile, String brand, int weight, int price,
                     boolean isLightsAvailable, String color,
                     int maxSpeed, int batteryCapacity) {
        super(isLoadedFromFile, brand, weight, price, isLightsAvailable, color);
        this.maxSpeed = maxSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    public Speedelec() {
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result * 31 + maxSpeed;
        result = 31 * result + batteryCapacity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Speedelec speedelec = (Speedelec) obj;
        if (speedelec.getClass().equals(this.getClass())) {
            return speedelec.getBatteryCapacity() == this.batteryCapacity
                    && speedelec.getMaxSpeed() == this.maxSpeed;
        }
        return false;
    }

    @Override
    public String toString() {
        return getBrand() + "; "
                + getMaxSpeed() + "; "
                + getWeight() + "; "
                + isLightsAvailable() + "; "
                + getBatteryCapacity() + "; "
                + getColor() + "; "
                + getPrice() + "\n";
    }
}
