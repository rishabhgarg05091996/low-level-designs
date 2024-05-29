package com.rishabh.splitwise;

import com.rishabh.splitwise.manager.ExpenseManager;
import com.rishabh.splitwise.model.User;
import com.rishabh.splitwise.model.expense.ExpenseMetadata;
import com.rishabh.splitwise.model.expense.ExpenseType;
import com.rishabh.splitwise.model.split.EqualSplit;
import com.rishabh.splitwise.model.split.ExactSplit;
import com.rishabh.splitwise.model.split.PercentSplit;
import com.rishabh.splitwise.model.split.Split;
import com.rishabh.splitwise.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		UserService userService = new UserService();
		ExpenseManager expenseManager = new ExpenseManager(userService);
		
		User user1 = new User("u1", "User1", "user1@test.com", "1234567890");
		User user2 = new User("u2", "User2", "user2@test.com", "1234567891");
		User user3 = new User("u3", "User3", "user3@test.com", "1234567892");
		User user4 = new User("u4", "User4", "user4@test.com", "1234567893");
		
		expenseManager.addUser(user1);
		expenseManager.addUser(user2);
		expenseManager.addUser(user3);
		expenseManager.addUser(user4);
		
		List<Split> splits = new ArrayList<>();
		splits.add(new EqualSplit(user1));
		splits.add(new EqualSplit(user2));
		splits.add(new EqualSplit(user3));
		splits.add(new EqualSplit(user4));
		
		expenseManager.addExpense(ExpenseType.EQUAL, 1000, "u1", splits, new ExpenseMetadata("Lunch", "", ""));
		
		splits = new ArrayList<>();
		splits.add(new ExactSplit(user1, 370));
		splits.add(new ExactSplit(user2, 320));
		splits.add(new ExactSplit(user3, 210));
		splits.add(new ExactSplit(user4, 100));
		
		expenseManager.addExpense(ExpenseType.EXACT, 1000, "u1", splits, new ExpenseMetadata("Dinner", "", ""));
		
		splits = new ArrayList<>();
		splits.add(new PercentSplit(user1, 40));
		splits.add(new PercentSplit(user2, 20));
		splits.add(new PercentSplit(user3, 20));
		splits.add(new PercentSplit(user4, 20));
		
		expenseManager.addExpense(ExpenseType.PERCENT, 1200, "u1", splits, new ExpenseMetadata("Trip", "", ""));
		
		expenseManager.showBalances();
		expenseManager.showBalance("u1");
		expenseManager.showBalance("u2");
		expenseManager.showBalance("u3");
		expenseManager.showBalance("u4");
	}
}