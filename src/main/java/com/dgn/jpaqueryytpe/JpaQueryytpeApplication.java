package com.dgn.jpaqueryytpe;

import com.dgn.jpaqueryytpe.model.Account;
import com.dgn.jpaqueryytpe.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaQueryytpeApplication implements CommandLineRunner {
	private final AccountRepository accountRepository;

	public JpaQueryytpeApplication(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaQueryytpeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 1; i < 10 ; i++) {
			String name = "Doğan " + i;
			String identityNumber="0000" + i;
			Account account = new Account(name,"Güneş","Ankara","0000000000","dogan@dogan.com",identityNumber);
			accountRepository.save(account);
		}
	}
}
