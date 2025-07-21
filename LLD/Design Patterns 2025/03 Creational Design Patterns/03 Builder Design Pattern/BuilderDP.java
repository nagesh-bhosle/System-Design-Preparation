class Sandwich {
    private String bread;
    private String filling;
    private String sauce;

    public Sandwich(String bread, String filling, String sauce) {
        this.bread = bread;
        this.filling = filling;
        this.sauce = sauce;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", filling='" + filling + '\'' +
                ", sauce='" + sauce + '\'' +
                '}';
    }
}

class SandwichBuilder {
    private String bread;
    private String filling;
    private String sauce;

    public SandwichBuilder setBread(String bread) {
        this.bread = bread;
        return this;
    }

    public SandwichBuilder setFilling(String filling) {
        this.filling = filling;
        return this;
    }

    public SandwichBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public Sandwich build() {
        return new Sandwich(bread, filling, sauce);
    }
}

public class BuilderDP {
    public static void main(String[] args) {
        Sandwich sandwich = new SandwichBuilder()
                .setBread("Whole Wheat")
                .setFilling("Turkey")
                .setSauce("Mustard")
                .build();

        System.out.println(sandwich);
    }
}
