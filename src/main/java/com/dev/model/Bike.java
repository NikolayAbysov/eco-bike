package com.dev.model;

public abstract class Bike {
    private boolean isLoadedFromFile;
    private Long id;
    private String brand;
    private int weight;
    private int price;
    private Boolean isLightsAvailable;
    private String color;

    public Bike(boolean isLoadedFromFile, String brand, int weight,
                int price, boolean isLightsAvailable, String color) {
        this.isLoadedFromFile = isLoadedFromFile;
        this.brand = brand;
        this.weight = weight;
        this.price = price;
        this.isLightsAvailable = isLightsAvailable;
        this.color = color;
    }

    public Bike() {
    }

    public boolean isLoadedFromFile() {
        return isLoadedFromFile;
    }

    public void setLoadedFromFile(boolean loadedFromFile) {
        isLoadedFromFile = loadedFromFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean isLightsAvailable() {
        return isLightsAvailable;
    }

    public void setLightsAvailable(boolean lightsAvailable) {
        isLightsAvailable = lightsAvailable;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 31 + weight;
        result = result * 31 + price;
        if (id != null) {
            result = result * 31 * id.hashCode();
        }
        if (brand != null) {
            result = result * 31 * brand.hashCode();
        }
        if (isLightsAvailable != null) {
            result = result * 31 * isLightsAvailable.hashCode();
        }
        if (color != null) {
            result = result * 31 * color.hashCode();
        }
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
        Bike bike = (Bike) obj;
        if (bike.getClass().equals(this.getClass())) {
            return (bike.getPrice() == this.price)
                    && (bike.getId() == this.id || ((bike.getId() != null && this.id != null)
                        && bike.getId().equals(this.id)))
                    && (bike.getBrand() == this.brand || ((bike.getBrand() != null
                        && this.brand != null) && bike.getBrand().equals(this.brand)))
                    && (bike.getColor() == this.color || ((bike.getColor() != null
                        && this.color != null) && bike.getColor().equals(this.color)))
                    && (bike.isLightsAvailable() == this.isLightsAvailable
                        || ((bike.isLightsAvailable() != null
                        && this.isLightsAvailable != null)
                        && bike.isLightsAvailable().equals(this.isLightsAvailable)))
                    && (bike.getWeight() == this.weight);
        }
        return false;
    }
}
