package com.rishabh.movieticketbookingsystem.notification.service;

import com.rishabh.movieticketbookingsystem.booking.model.Booking;
import com.rishabh.movieticketbookingsystem.notification.model.Notification;
import com.rishabh.movieticketbookingsystem.notification.model.NotificationStatus;
import com.rishabh.movieticketbookingsystem.notification.model.NotificationType;
import com.rishabh.movieticketbookingsystem.user.model.User;

import java.util.UUID;

public class NotificationService {
	public Notification createNotification(User user, Booking booking, NotificationType type) {
		return new Notification(UUID.randomUUID().toString(), user, booking, type, NotificationStatus.PENDING);
	}
	
	public boolean sendNotification(Notification notification) {
		// Implement actual notification sending logic here
		notification.setStatus(NotificationStatus.SENT);
		System.out.println("Notification sent successfully for Notification ID: " + notification.getId());
		return true;
	}
}