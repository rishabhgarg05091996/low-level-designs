package com.rishabh.movieticketbookingsystem.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Theater {
	private final String id;
	private final String name;
	private final String location;
	private final List<Show> shows;
}