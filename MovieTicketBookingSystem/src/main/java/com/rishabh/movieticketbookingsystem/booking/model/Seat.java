package com.rishabh.movieticketbookingsystem.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Seat {
	private final String id;
	private final int row;
	private final int column;
	private final SeatType type;
	private final double price;
	@Setter
	private SeatStatus status;
}