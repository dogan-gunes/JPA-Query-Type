package com.dgn.jpaqueryytpe.service;

import com.dgn.jpaqueryytpe.model.Account;
import com.dgn.jpaqueryytpe.model.AccountDto;
import com.dgn.jpaqueryytpe.model.AccountDtoByNative;
import com.dgn.jpaqueryytpe.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findUserByIdentityNumber(String identityNumber){
        return accountRepository.findAccountByIdentityNumber(identityNumber).orElse(null);
    }
    public Account getAccountByIdentityNumberQuery1(String identityNumber){
        return accountRepository.getAccountByIdentityNumberQuery1(identityNumber).orElse(null);
    }
    public Account getAccountByIdentityNumberQuery2(String identityNumber){
        return accountRepository.getAccountByIdentityNumberQuery2(identityNumber).orElse(null);
    }
//dto

    public AccountDto getAccountDtoByIdentityNumberQuery1(String identityNumber){
        return accountRepository.getAccountDtoByIdentityNumberQuery1(identityNumber);
    }

    public AccountDtoByNative getAccountDtoByIdentityNumberQuery2(String identityNumber){
        return accountRepository.getAccountDtoByIdentityNumberQuery2(identityNumber).orElse(null);
    }

    // string

    public String getAccountNameByIdentityNumberQuery1(String identityNumber){
        return accountRepository.getAccountNameByIdentityNumberQuery1(identityNumber);
    }

    public String getAccountNameByIdentityNumberQuery2(String identityNumber){
        return accountRepository.getAccountNameByIdentityNumberQuery2(identityNumber);
    }

    // List<Account>

    public List<Account> findAllAccountBySurname(String surname){

        return accountRepository.findAllBySurname(surname);
    }

    public List<Account> getAllAccountBySurnameQuery1(String surname){
        return accountRepository.getAllAccountBySurnameQuery1(surname);
    }

    public List<Account> getAllAccountBySurnameQuery2(String surname){
        return accountRepository.getAllAccountBySurnameQuery2(surname);
    }
}
