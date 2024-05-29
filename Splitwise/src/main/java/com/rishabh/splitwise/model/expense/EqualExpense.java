package com.rishabh.splitwise.model.expense;

import com.rishabh.splitwise.model.split.EqualSplit;
import com.rishabh.splitwise.model.split.Split;
import com.rishabh.splitwise.model.User;

import java.util.List;

public class EqualExpense extends Expense {
	public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
		super(null, amount, paidBy, splits, expenseMetadata);
	}
	
	@Override
	public boolean validate() {
		return getSplits().stream().allMatch(EqualSplit.class::isInstance);
	}
}