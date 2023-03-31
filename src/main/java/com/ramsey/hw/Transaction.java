package com.ramsey.hw;

import lombok.Value;

@Value
public class Transaction {
    long id;
    long customerId;
    double amount;
}
