import { Component } from '@angular/core';
import { NotificationService } from '../service/notification.service';
import { Notification } from '../models/notification';

@Component({
  selector: 'ntap-notification-list',
  templateUrl: './notification-list.component.html',
  styleUrls: ['./notification-list.component.scss'],
})
export class NotificationListComponent {
  notification = {} as Notification;
  notifications: Notification[] = [];

  constructor(private notificationService: NotificationService) {}

  ngOnInit() {
    this.getNotifications();
  }

  getNotifications() {
    this.notificationService
      .getNotifications()
      .subscribe((notifications: Notification[]) => {
        this.notifications = notifications;
      });
  }
}
