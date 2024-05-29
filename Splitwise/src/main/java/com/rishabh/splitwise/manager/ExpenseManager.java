package com.rishabh.splitwise.manager;

import com.rishabh.splitwise.model.User;
import com.rishabh.splitwise.model.expense.Expense;
import com.rishabh.splitwise.model.expense.ExpenseMetadata;
import com.rishabh.splitwise.model.expense.ExpenseType;
import com.rishabh.splitwise.model.split.Split;
import com.rishabh.splitwise.service.ExpenseService;
import com.rishabh.splitwise.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
	private final List<Expense> expenses;
	private final UserService userService;
	private final Map<String, Map<String, Double>> balanceSheet;
	
	public ExpenseManager(UserService userService) {
		expenses = new ArrayList<>();
		this.userService = userService;
		balanceSheet = new HashMap<>();
	}
	
	public void addUser(User user) {
		userService.addUser(user);
		balanceSheet.put(user.getId(), new HashMap<>());
	}
	
	public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
		Expense expense = ExpenseService.createExpense(expenseType, amount, userService.getUserById(paidBy), splits, expenseMetadata);
		if (expense.validate()) {
			expenses.add(expense);
			splits.forEach(split -> updateBalanceSheet(paidBy, split.getUser().getId(), split.getAmount()));
		} else {
			throw new IllegalArgumentException("Invalid expense splits");
		}
	}
	
	private void updateBalanceSheet(String paidBy, String paidTo, double amount) {
		balanceSheet.computeIfAbsent(paidBy, k -> new HashMap<>()).merge(paidTo, amount, Double::sum);
		balanceSheet.computeIfAbsent(paidTo, k -> new HashMap<>()).merge(paidBy, -amount, Double::sum);
	}
	
	public void showBalance(String userId) {
		Map<String, Double> balances = balanceSheet.get(userId);
		if (balances == null || balances.isEmpty()) {
			System.out.println("No balances");
			return;
		}
		balances.forEach((key, value) -> {
			if (value != 0) printBalance(userId, key, value);
		});
	}
	
	public void showBalances() {
		balanceSheet.forEach((user1, balances) -> balances.forEach((user2, amount) -> {
			if (amount != 0) printBalance(user1, user2, amount);
		}));
	}
	
	private void printBalance(String user1, String user2, double amount) {
		String user1Name = userService.getUserById(user1).getName();
		String user2Name = userService.getUserById(user2).getName();
		if (amount < 0) {
			System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
		} else {
			System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
		}
	}
}
