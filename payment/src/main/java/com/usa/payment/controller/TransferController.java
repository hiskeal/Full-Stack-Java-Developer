package com.usa.payment.controller;

import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.Dto.TransferRequestDto;
import com.usa.payment.model.Transfer;
import com.usa.payment.service.TransferService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/saveTransfer")
    public ResponseDto saveTransfer(@RequestBody TransferRequestDto transferRequestDto) {
         transferService.saveTransfer(transferRequestDto);
        return new ResponseDto(true, "Updated Account Successfully");
    }

    @PutMapping("/updateTransfer/{id}")
    public ResponseDto updateTransfer(@PathVariable Long id, @RequestBody TransferRequestDto transferRequestDto) {
         transferService.updateTransfer(transferRequestDto, id);
         return new ResponseDto(true, "Updated Transfer Successfully");
    }

    @DeleteMapping("/deleteTransfer/{id}")
    public ResponseDto deleteTransfer(@PathVariable("id") Long id) {
          transferService.deleteTransferById(id);

        return new ResponseDto(true, "Deleted Account Successfully");
    }

    @GetMapping("/listTransfer")
    public List<Transfer> ListAll() {
        return transferService.ListAll();
    }

//    @GetMapping("/getTransfer/{id}")
//    public Transfer getTransferById(@PathVariable Long id) {
//         return transferService.getTransferById(id);
//    }


}
