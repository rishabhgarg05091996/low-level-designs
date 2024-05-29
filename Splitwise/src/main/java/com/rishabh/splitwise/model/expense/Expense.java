package com.rishabh.splitwise.model.expense;

import com.rishabh.splitwise.model.split.Split;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.rishabh.splitwise.model.User;

import java.util.List;

@Data
@AllArgsConstructor
public abstract class Expense {
	private String id;
	private double amount;
	private User paidBy;
	private List<Split> splits;
	private ExpenseMetadata metadata;
	
	public abstract boolean validate();
}
