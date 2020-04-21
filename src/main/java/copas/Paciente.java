package main.java.copas;

import java.util.Date;

public class Paciente {
    private int cpf;
    private int rg;
    private String name;
    private String email;
    private String susCard;
    private Date bornDate;
    private String address;
    private String password;
    private String status;

    public Paciente() {
    }

    public Paciente(int cpf, int rg, String name, String email, String susCard, Date bornDate, String address,
            String password, String status) {
        this.setCpf(cpf);
        this.setRg(rg);
        this.setName(name);
        this.setEmail(email);
        this.setSusCard(susCard);
        this.setBornDate(bornDate);
        this.setAddress(address);
        this.setPassword(password);
    }

    public int getCpf() {
        return this.cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return this.rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSusCard() {
        return this.susCard;
    }

    public void setSusCard(String susCard) {
        this.susCard = susCard;
    }

    public Date getBornDate() {
        return this.bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void atualizarSintomas() {
    }

    public void cadastrarDados() {
    }

    public void consultarNotificacoes() {
    }

    public void listarSintomas() {
    }

    public void visualizarStatus() {
    }

    public void consultarMensagens() {
    }

    public void consultarAgenda() {
    }
}