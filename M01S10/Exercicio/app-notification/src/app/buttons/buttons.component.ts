import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NotificationListComponent } from '../notification-list/notification-list.component';

@Component({
  selector: 'ntap-buttons',
  templateUrl: './buttons.component.html',
  styleUrls: ['./buttons.component.scss'],
})
export class ButtonsComponent {
  constructor(
    private route: ActivatedRoute,
    private notificationList: NotificationListComponent
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.notificationList.filterNotifications(params['status']);
    });
  }
}
