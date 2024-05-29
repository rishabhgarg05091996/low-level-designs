package com.rishabh.splitwise.model.split;

import com.rishabh.splitwise.model.User;

public class ExactSplit extends Split {
	public ExactSplit(User user, double amount) {
		super(user);
		this.setAmount(amount);
	}
}