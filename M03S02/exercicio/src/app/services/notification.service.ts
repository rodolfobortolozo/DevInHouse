import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { INotificacao } from '../models/notificacao.model';
import { NOTIFICATIONS_MOCK } from '../utils/notifications-mock';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  BASE_URL = 'http://localhost:3000/notifications';

  constructor(private http: HttpClient) { }

  getNotifications(): Observable<INotificacao[]> {
    return of(NOTIFICATIONS_MOCK);
  }

  getNotificationsApi(): Observable<any> {
    return this.http.get<any>(`${this.BASE_URL}`);
  }

  addNotificationApi(notification: any): Observable<any> {
    return this.http.post<any>(`${this.BASE_URL}`, notification);
  }

  editNotificationApi(notification: any): Observable<any> {
    const id = notification.id;
    return this.http.put<any>(`${this.BASE_URL}/${id}`, notification);
  }

  removeNotification(id: number) {
    return this.http.delete<any>(`${this.BASE_URL}/${id}`, );
  }
}
