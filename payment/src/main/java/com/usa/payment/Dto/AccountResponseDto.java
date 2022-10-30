package com.usa.payment.Dto;


import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDto {

    private Long id;

    private float balance;

    private Long personId;

    private Instant updatedOn;

    private Date createdOn;
}
