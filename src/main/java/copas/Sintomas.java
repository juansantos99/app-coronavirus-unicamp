package main.java.copas;

public class Sintomas {
    private int id;
    private String description;

    public Sintomas(int id, String description) {
        this.setId(id);
        this.setDescription(description);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}