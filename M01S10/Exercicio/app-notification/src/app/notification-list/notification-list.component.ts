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
  notificationsFiltered: Notification[] = [];

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

  filterNotifications(pStatus: string) {
    let status: Boolean;

    if (pStatus === 'lidos') {
      status = true;
    } else if (pStatus === 'nao-lidos') {
      status = false;
    } else {
      this.getNotifications();
    }

    this.notifications = this.notifications.filter(
      (notification) => notification.lida == status
    );
  }

  //Marca como Lida
  visualized(id: number) {
    let index = -1;
    index = this.notifications.findIndex((item) => item.id == id);
    if (index != -1) {
      if (this.notifications[index].lida) {
        this.notifications[index].lida = false;
      } else {
        this.notifications[index].lida = true;
        // this.notifications.splice(index, 1);
      }
    }
  }
}
