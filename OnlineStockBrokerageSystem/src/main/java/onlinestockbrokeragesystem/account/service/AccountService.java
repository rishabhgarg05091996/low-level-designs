package onlinestockbrokeragesystem.account.service;

import onlinestockbrokeragesystem.account.model.Account;
import onlinestockbrokeragesystem.account.model.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountService {
	private final ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
	private final AtomicInteger accountIdCounter = new AtomicInteger(1);
	
	public Account createAccount(User user, double initialBalance) {
		String accountId = generateAccountId();
		Account account = new Account(accountId, user, initialBalance);
		accounts.put(accountId, account);
		return account;
	}
	
	public Account getAccount(String accountId) {
		return accounts.get(accountId);
	}
	
	private String generateAccountId() {
		int accountId = accountIdCounter.getAndIncrement();
		return "A" + String.format("%03d", accountId);
	}
}
