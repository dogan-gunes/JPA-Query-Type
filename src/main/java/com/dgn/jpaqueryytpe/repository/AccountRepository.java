package com.dgn.jpaqueryytpe.repository;

import com.dgn.jpaqueryytpe.model.Account;
import com.dgn.jpaqueryytpe.model.AccountDto;
import com.dgn.jpaqueryytpe.model.AccountDtoByNative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByIdentityNumber(String identityNumber);

    @Query("from Account where identityNumber=?1")
    Optional<Account> getAccountByIdentityNumberQuery1(String identityNumber);

    @Query(value = "select * from Account where identity_number=?", nativeQuery = true)
    Optional<Account> getAccountByIdentityNumberQuery2(String identityNumber);


    //dto
    @Query("select new com.dgn.jpaqueryytpe.model.AccountDto(a.name,a.surname) from Account a where a.identityNumber=?1")
    AccountDto getAccountDtoByIdentityNumberQuery1(String identityNumber);

    @Query(value = "select a.NAME,a.SURNAME from Account a where a.identitiy_number=?", nativeQuery = true)
    Optional<AccountDtoByNative> getAccountDtoByIdentityNumberQuery2(String identityNumber);


    // Tek Bir String Değer Dönen
    @Query("select a.name from Account a where a.identityNumber=?1")
    String getAccountNameByIdentityNumberQuery1(String identityNumber);

    @Query(value = "select name from Account where identity_number=?",nativeQuery = true)
    String getAccountNameByIdentityNumberQuery2(String identityNumber);

    // List<Account>

    List<Account> findAllBySurname(String surname);

    @Query("FROM Account a where a.surname=?1")
    List<Account> getAllAccountBySurnameQuery1(String surname);

    @Query(value = "select * from Account where surname=?",nativeQuery = true)
    List<Account> getAllAccountBySurnameQuery2(String surname);
}
