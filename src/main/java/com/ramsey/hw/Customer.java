package com.ramsey.hw;

import lombok.Value;

import java.util.List;

@Value
public class Customer {
    long id;
    String name;
    List<Transaction> transactionList;
}
