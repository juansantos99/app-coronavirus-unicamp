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

    public void registerPatient() {
        // Cadastrar novo paciente
    }

    public void consult() {
        // Retorna todos pacientes que tem no banco, com filtro: sintoma, regiao, todos
    }

    public void showPatient() {
        // mostra um paciente pelo ID ou CPF
    }

    public void consultSchedule() {
        // Retorna os agendamentos que ele agendou
    }

    public void scheduleVisit() {
        // Cria um agendamento
    }

    public void getVisit() {
        // Baixa o prontuario de um paciente em PDF
    }

    public void registerMedicalReport() {
        // Cria o prontuario
    }

    public void updateStatus() {
        // Muda o status de um paciente
    }

    public void contactPatient() {
        // Manda uma notificação para o paciente pelo CPF
    }
}