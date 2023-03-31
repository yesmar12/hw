package com.ramsey.hw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PointsController {
    @GetMapping("/customers/{customerId}/points")
    public int calculatePoints(@PathVariable long customerId){
        Customer customer = getCustomerById(customerId);
        List<Transaction>  transactions = customer.getTransactionList();
        int totalPoints = 0;
        for (Transaction t : transactions) {
            double amount = t.getAmount();
            if (amount > 100) {
                totalPoints += (int) ((amount - 100) * 2);
            }
            if (amount >= 50 && amount <= 100) {
                totalPoints += (int) (amount - 50);
            }
        }
        return totalPoints;
    }

    // helper method to get the customer by ID
    private Customer getCustomerById(long customerId) {
        // this could be replaced with a database lookup
        // for the sake of simplicity, we will use a hardcoded customer
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, customerId, 150.0));
        transactions.add(new Transaction(2, customerId, 75.0));
        transactions.add(new Transaction(3, customerId, 200.0));
        return new Customer(customerId, "Ramsey", transactions);
    }
}
