package ee.bcs.java.learning;

public enum EnumSeason {
    SUMMER(35), //это объекты енама EnumSeason
    WINTER(-30), //java сама создаёт new эти объекты
    AUTUMN(10),
    SPRING(20);
    //БОЛЬШИЕ буквы, т.к это константы

    private int temperature;

    EnumSeason (int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
