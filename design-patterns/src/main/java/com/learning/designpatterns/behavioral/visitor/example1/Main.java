package com.learning.designpatterns.behavioral.visitor.example1;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final var bank = new Bank("sbi", "hyderabad", "12345", 50);
        final var resident = new Resident("tulasi", "hyd", "23456", "standard");
        final var company = new Company("IBM", "hyd", "34567", 20000);
        List<Client> clients = List.of(bank, resident, company);
        final var visitor = new InsuranceMessageVisitor();
        visitor.sendInsuranceMails(clients);
    }
}
