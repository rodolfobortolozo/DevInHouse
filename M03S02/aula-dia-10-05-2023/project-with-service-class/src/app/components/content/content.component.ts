import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { INotification } from 'src/app/models/notification.model';
import { NotificationService } from 'src/app/services/notification.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  listaDeNotificacoes: INotification[] = [];

  notifications$: Observable<INotification[]> = this.notificationService.getNotifications();

  constructor(private notificationService: NotificationService) {}

  ngOnInit() {
   this.carregarNotificacoes();
  }

  lerNotificacao(notificacao: INotification) {
    notificacao = {
      ...notificacao,
      lido: true
    }

    this.notificationService
      .editNotificationApi(notificacao)
      .subscribe(() => this.atualizarLista());
  }

  atualizarLista() {
    this.carregarNotificacoes();
  }

  carregarNotificacoes() {
    this.notificationService
      .getNotifications()
      .subscribe((resposta: INotification[]) => {
        this.listaDeNotificacoes = resposta
      });
  }

  removerNotificacao(id?: number) {
    if (id) {
      this.notificationService
        .removeNotification(id)
        .subscribe(() => {
          this.atualizarLista();
        });
    }
  }
}
