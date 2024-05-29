package com.rishabh.splitwise.model.split;

import com.rishabh.splitwise.model.User;
import lombok.Data;

@Data
public class PercentSplit extends Split {
	private double percent;
	
	public PercentSplit(User user, double percent) {
		super(user);
		this.percent = percent;
	}
}