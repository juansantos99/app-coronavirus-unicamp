package main.java.copas;
public class SymptonsPatient {
	private int id;
    private int cpf;
    private int symptonsid;

    public SymptonsPatient(int id,int symptonsid, int cpf) {
        this.setId(id);
        this.setSymptonsid(symptonsid);
        this.setCpf(cpf);
        
    }
	public SymptonsPatient() {
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getSymptonsid() {
		return symptonsid;
	}
	public void setSymptonsid(int symptonsid) {
		this.symptonsid = symptonsid;
	}
}