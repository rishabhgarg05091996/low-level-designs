package com.rishabh.splitwise.model.expense;

import com.rishabh.splitwise.model.split.PercentSplit;
import com.rishabh.splitwise.model.split.Split;
import com.rishabh.splitwise.model.User;

import java.util.List;

public class PercentExpense extends Expense {
	public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
		super(null, amount, paidBy, splits, expenseMetadata);
	}
	
	@Override
	public boolean validate() {
		return getSplits().stream().allMatch(PercentSplit.class::isInstance) &&
				getSplits().stream().mapToDouble(split -> ((PercentSplit) split).getPercent()).sum() == 100.0;
	}
}