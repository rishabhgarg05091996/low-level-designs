package com.rishabh.movieticketbookingsystem.notification.model;

import com.rishabh.movieticketbookingsystem.booking.model.Booking;
import com.rishabh.movieticketbookingsystem.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Notification {
	private String id;
	private User user;
	private Booking booking;
	private NotificationType type;
	private NotificationStatus status;
}