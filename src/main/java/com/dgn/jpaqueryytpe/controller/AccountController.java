package com.dgn.jpaqueryytpe.controller;

import com.dgn.jpaqueryytpe.model.Account;
import com.dgn.jpaqueryytpe.model.AccountDto;
import com.dgn.jpaqueryytpe.model.AccountDtoByNative;
import com.dgn.jpaqueryytpe.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/findUserByIdentityNumber/{identityNumber}")
    public ResponseEntity<Account> findUserByIdentityNumber(@PathVariable String identityNumber) {
        return new ResponseEntity<>(accountService.findUserByIdentityNumber(identityNumber), HttpStatus.OK);
    }
    @GetMapping("/getAccountByIdentityNumberQuery1/{identityNumber}")
    public ResponseEntity<Account> getAccountByIdentityNumberQuery1(@PathVariable String identityNumber){
        return new ResponseEntity<>(accountService.getAccountByIdentityNumberQuery1(identityNumber),HttpStatus.OK);
    }

    @GetMapping("/getAccountByIdentityNumberQuery2/{identityNumber}")
    public ResponseEntity<Account> getAccountByIdentityNumberQuery2(@PathVariable String identityNumber){
        return new ResponseEntity<>(accountService.getAccountByIdentityNumberQuery2(identityNumber),HttpStatus.OK);
    }

    //dto

    @GetMapping("/getAccountDtoByIdentityNumberQuery1/{identityNumber}")
    public ResponseEntity<AccountDto> getAccountDtoByIdentityNumberQuery1(@PathVariable String identityNumber){
        return new ResponseEntity<>(accountService.getAccountDtoByIdentityNumberQuery1(identityNumber),HttpStatus.OK);
    }

    @GetMapping("/getAccountDtoByIdentityNumberQuery2/{identityNumber}")
    public ResponseEntity<AccountDtoByNative> getAccountDtoByIdentityNumberQuery2(@PathVariable String identityNumber){
        return new ResponseEntity<>(accountService.getAccountDtoByIdentityNumberQuery2(identityNumber),HttpStatus.OK);
    }

    //string

    @GetMapping("/getAccountNameByIdentityNumberQuery1/{identityNumber}")
    public ResponseEntity<String> getAccountNameByIdentityNumberQuery1(@PathVariable String identityNumber){
        return new ResponseEntity<>(accountService.getAccountNameByIdentityNumberQuery1(identityNumber),HttpStatus.OK);
    }


    @GetMapping("/getAccountNameByIdentityNumberQuery2/{identityNumber}")
    public ResponseEntity<String> getAccountNameByIdentityNumberQuery2(@PathVariable String identityNumber){
        return new ResponseEntity<>(accountService.getAccountNameByIdentityNumberQuery2(identityNumber),HttpStatus.OK);
    }

    //List<Account>
    @GetMapping("/findAllAccountBySurname/{surname}")
    public ResponseEntity<List<Account>> findAllAccountBySurname(@PathVariable String surname){
        return new ResponseEntity<>(accountService.findAllAccountBySurname(surname),HttpStatus.OK);
    }

    @GetMapping("/getAllAccountBySurnameQuery1/{surname}")
    public ResponseEntity<List<Account>> getAllAccountBySurnameQuery1(@PathVariable String surname){
        return new ResponseEntity<>(accountService.getAllAccountBySurnameQuery1(surname),HttpStatus.OK);
    }

    @GetMapping("/getAllAccountBySurnameQuery2/{surname}")
    public ResponseEntity<List<Account>> getAllAccountBySurnameQuery2(@PathVariable String surname){
        return new ResponseEntity<>(accountService.getAllAccountBySurnameQuery2(surname),HttpStatus.OK);
    }
}
