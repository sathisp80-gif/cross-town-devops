package com.citizens.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "transaction", schema = "public")
@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    public Long id;
    @Column(name = "transaction_code")
    public String transactionCode;
    @Column(name = "transaction_status")
    public String transactionStatus;
    @Column(name = "transaction_from_account")
    public String transactionFrom;
    @Column(name = "transaction_to_account")
    public String transactionTo;
    @Column(name = "transaction_desc")
    public String transactionDesc;
    @Column(name = "transaction_amount")
    public Long transactionAmount;


}
