package com.usa.payment.Dto;


import com.usa.payment.model.Account;
import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequestDto {

    private Account account;

    private Instant updatedOn;

    private Date createdOn;
}
