package com.learning.designpatterns.behavioral.visitor.example1;

import java.util.List;

public class InsuranceMessageVisitor implements Visitor{

    public void sendInsuranceMails(List<Client> clients){
        for(Client client: clients){
                client.accept(this);
        }
    }

    public void visitBank(Bank bank){
        System.out.println("Sending email about theft banking");
    }

    public void visitCompany(Company company){
        System.out.println("Sending email about equipment and safety");
    }

    public void visitResident(Resident resident){
        System.out.println("Sending email about medical insurance");
    }
}

