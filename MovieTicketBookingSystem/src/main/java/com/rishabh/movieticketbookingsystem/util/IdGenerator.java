package com.rishabh.movieticketbookingsystem.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
	private static final String BOOKING_ID_PREFIX = "BKG";
	private static final AtomicLong bookingCounter = new AtomicLong(0);
	
	public static String generateBookingId() {
		long bookingNumber = bookingCounter.incrementAndGet();
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		return BOOKING_ID_PREFIX + timestamp + String.format("%06d", bookingNumber);
	}
}