package com.rishabh.splitwise.model.split;

import lombok.Data;
import com.rishabh.splitwise.model.User;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Split {
	private User user;
	private double amount;
	
	protected Split(User user) {
		this.user = user;
	}
}
