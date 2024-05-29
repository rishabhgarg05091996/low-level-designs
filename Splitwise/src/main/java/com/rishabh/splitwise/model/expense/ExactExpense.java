package com.rishabh.splitwise.model.expense;

import com.rishabh.splitwise.model.split.ExactSplit;
import com.rishabh.splitwise.model.split.Split;
import com.rishabh.splitwise.model.User;

import java.util.List;

public class ExactExpense extends Expense {
	public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
		super(null, amount, paidBy, splits, expenseMetadata);
	}
	
	@Override
	public boolean validate() {
		return getSplits().stream().allMatch(ExactSplit.class::isInstance) &&
				getSplits().stream().mapToDouble(Split::getAmount).sum() == getAmount();
	}
}