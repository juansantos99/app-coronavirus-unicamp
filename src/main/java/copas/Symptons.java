package main.java.copas;

public class Symptons {
    private int id;
    private String description;

    public Symptons(int id, String description) {
        super();
    	this.id =id;
        this.description=description;
    }
    public Symptons() {
       
    }
    
    public String toString() {
        return "ID: " + this.getId() + " Descricao: " + this.getDescription() ;
    }
    
    public Symptons(String description) {
        super();
        this.description=description;
    }
    public Symptons(int id) {
        super();
        this.id=id;
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