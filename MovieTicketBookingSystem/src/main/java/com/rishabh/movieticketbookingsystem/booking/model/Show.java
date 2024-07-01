package com.rishabh.movieticketbookingsystem.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Show {
	private final String id;
	private final Movie movie;
	private final Theater theater;
	private final LocalDateTime startTime;
	private final LocalDateTime endTime;
	private final Map<String, Seat> seats;
}
