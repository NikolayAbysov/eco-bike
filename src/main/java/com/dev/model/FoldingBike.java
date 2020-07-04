package com.dev.model;

public class FoldingBike extends Bike {
    private int wheelSize;
    private int gearsNumber;

    public FoldingBike(boolean isLoadedFromFile, String brand, int weight, int price,
                       boolean isLightsAvailable, String color,
                       int wheelSize, int gearsNumber) {
        super(isLoadedFromFile, brand, weight, price, isLightsAvailable, color);
        this.wheelSize = wheelSize;
        this.gearsNumber = gearsNumber;
    }

    public FoldingBike() {
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public int getGearsNumber() {
        return gearsNumber;
    }

    public void setGearsNumber(int gearsNumber) {
        this.gearsNumber = gearsNumber;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result * 31 + wheelSize;
        result = 31 * result + gearsNumber;
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
        FoldingBike foldingBike = (FoldingBike) obj;
        if (foldingBike.getClass().equals(this.getClass())) {
            return foldingBike.getWheelSize() == this.wheelSize
                    && foldingBike.getGearsNumber() == this.gearsNumber;
        }
        return false;
    }

    @Override
    public String toString() {
        return getBrand() + "; "
                + getWheelSize() + "; "
                + getGearsNumber() + "; "
                + getWeight() + "; "
                + isLightsAvailable() + "; "
                + getColor() + "; "
                + getPrice() + "\n";
    }
}
