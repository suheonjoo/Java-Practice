package me.whiteship.refactoring._21_alternative_classes_with_different_interfaces._02_after;

public class OrderProcessor {

    private NotificationService notificationService;

    public OrderProcessor(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyShipping(Shipping shipping) {
        Notification notification = Notification.newNotification(shipping.getEmail() + " is shipped")
                .receiver(shipping.getEmail())
                .sender("no-reply@whiteship.com");
        notificationService.sendNotification(notification);

    }

}
