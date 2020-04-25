package main.java.copas;

public class HealthProfessional {
    private int id;
    private int rg;
    private int cpf;
    private String name;
    private String role;

    public HealthProfessional() {
    }

    public HealthProfessional(int id, int rg, int cpf, String name, String role) {
        this.setId(id);
        this.setRg(rg);
        this.setCpf(cpf);
        this.setName(name);
        this.setRole(role);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRg() {
        return this.rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return this.cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void register() {
    }

    public void consult() {
    }

    public void showPatient(Patient patient) {
 
    	Symptons symptons = new Symptons();
    	if (patient.getCpf() != 0) {
    		System.out.println(patient.getCpf());
    		System.out.println(patient.getName());
    		System.out.println(patient.getEmail());
    		System.out.println(patient.getName());
    		System.out.println(patient.getSusCard());
    		System.out.println(patient.getBornDate());
    		System.out.println(patient.getStatus());
    	}
    }

    public void consultSchedule() {
    }

    public void scheduleVisit() {
    }

    public void getVisit() {
    }

    public void registerMedicalReport() {
    }

    public void updateStatus() {
    }

    public void contactPatient() {
    }
}