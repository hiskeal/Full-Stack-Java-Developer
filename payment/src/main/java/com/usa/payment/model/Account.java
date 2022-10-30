package com.usa.payment.model;


//import java.time.Instant;
import java.time.Instant;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @Column(name = "account_id", nullable = false)
    private Long id;
    @Column(name = "balance")
    private float balance;

    @Column(name = "person_id", nullable = false)
    private Long personId;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "account_status")
    private String accountStatus;


}