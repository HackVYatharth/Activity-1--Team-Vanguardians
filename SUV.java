class SUV extends Car {
    int weight;

    public int getWeight()
    {
        return weight;
    }
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    SUV(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        if (weight > 2000) {
            return getRegularPrice() * 0.9; // 10% discount
        } else {
            return getRegularPrice() * 0.8; // 20% discount
        }
    }
}
