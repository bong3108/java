package org.example.procject;

public class Account {

    private String ano;
    private String owner;
    private int balance;

    public Account(String ano, String owner, int balance) {
        this.ano = ano;
        this.owner = owner;
        this.balance = balance;
    }

    protected String getAno() { return ano; }
    protected void setAno(String ano) { this.ano = ano; }
    protected String getOwner() { return owner; }
    protected void setOwner(String owner) { this.owner = owner; }
    protected int getBalance() { return balance; }
    protected void setBalance(int balance) { this.balance = balance; }

    public void deposit(int amount) {
        this.balance += amount;

    }
    public int withdraw(int amount) throws Exception {
        if(this.balance < amount) {
            throw new Exception("잔액이 부족합니다.");
        }else {
            this.balance -= amount;

        }
        return amount;
    }
}
