package com.usa.payment.service;

import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.Dto.TransferRequestDto;
import com.usa.payment.Dto.TransferResponseDto;
import com.usa.payment.model.Transfer;
import com.usa.payment.repository.TransferRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public ResponseDto saveTransfer(TransferRequestDto transferRequestDto){
        Transfer transfer = new Transfer();

        transfer.setAccount(transferRequestDto.getAccount());
        transfer.setCreatedOn(transferRequestDto.getCreatedOn());
        transfer.setUpdatedOn(transferRequestDto.getUpdatedOn());
      //  transfer.setId(transfer.getId());

        transferRepository.save(transfer);
        return new ResponseDto(true, "created transfer");
    }

    public ResponseDto updateTransfer(TransferRequestDto transferRequestDto, Long id){

        Transfer transfer = new Transfer();

        transfer.setAccount(transferRequestDto.getAccount());
        transfer.setCreatedOn(transferRequestDto.getCreatedOn());
        transfer.setUpdatedOn(transferRequestDto.getUpdatedOn());
     //   transfer.setId(transfer.getId());
        transferRepository.save(transfer);

        return new ResponseDto(true,"Updated transfer success");
    }

    public ResponseDto deleteTransferById(Long id){
        transferRepository.deleteById(id);
        return new ResponseDto(true,"deleted by id success");
    }

    public ResponseDto deleteTransfer(Long id, Transfer transfer){
        transferRepository.delete(transfer);
        return new ResponseDto(true,"deleted by id success");
    }
//
//    public Transfer getTransferById(Long id){
//      return transferRepository.findById(id).get();
//    }

    public List<Transfer> ListAll(){
        List<TransferResponseDto> transferResponseDto = new ArrayList<>();
        return (List<Transfer>) transferRepository.findAll();
    }

}
