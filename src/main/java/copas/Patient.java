package main.java.copas;

import java.util.Date;

public class Patient {
    private int cpf;
    private int rg;
    private String nome;
    private String email;
    private String susCard;
    private Date bornDate;
    private String address;
    private String password;
    private String status;

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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void updateSymptons() {
    }

    public void registerData() {
    }

    public void consultNotifications() {
    }

    public void listSymptons() {
    }

    public void showStatus() {
    }

    public void consultMessages() {
    }

    public void consultSchedule() {
    }
}