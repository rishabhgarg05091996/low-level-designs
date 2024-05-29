package com.rishabh.splitwise.service;

import com.rishabh.splitwise.model.User;
import com.rishabh.splitwise.model.expense.ExactExpense;
import com.rishabh.splitwise.model.expense.Expense;
import com.rishabh.splitwise.model.expense.ExpenseMetadata;
import com.rishabh.splitwise.model.expense.ExpenseType;
import com.rishabh.splitwise.model.expense.EqualExpense;
import com.rishabh.splitwise.model.expense.PercentExpense;
import com.rishabh.splitwise.model.split.PercentSplit;
import com.rishabh.splitwise.model.split.Split;

import java.util.List;

public class ExpenseService {
	public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
		switch (expenseType) {
			case EXACT:
				return new ExactExpense(amount, paidBy, splits, expenseMetadata);
			case PERCENT:
				splits.forEach(split -> split.setAmount((amount * ((PercentSplit) split).getPercent()) / 100.0));
				return new PercentExpense(amount, paidBy, splits, expenseMetadata);
			case EQUAL:
				int totalSplits = splits.size();
				double splitAmount = (Math.round(amount * 100 / totalSplits)) / 100.0;
				splits.forEach(split -> split.setAmount(splitAmount));
				splits.get(0).setAmount(splitAmount + (amount - splitAmount * totalSplits));
				return new EqualExpense(amount, paidBy, splits, expenseMetadata);
			default:
				throw new IllegalArgumentException("Invalid expense type");
		}
	}
}
