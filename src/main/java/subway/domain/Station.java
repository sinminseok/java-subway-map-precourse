package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(final String name){
        return this.name.equals(name);
    }
}
