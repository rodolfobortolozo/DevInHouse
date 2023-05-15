import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { INotificacao } from 'src/app/models/notificacao.model';
import { NotificationService } from 'src/app/services/notification.service';

@Component({
  selector: 'ntap-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.scss'],
})
export class ContentComponent implements OnInit {
  listaDeNotificacoes: INotificacao[] = [];

  notifications$: Observable<INotificacao[]> = this.notificationService.getNotifications();

  constructor(private notificationService: NotificationService) {}

  ngOnInit() {
    this.carregarNotificacoes();
  }

  lerNotificacao(notificacao: INotificacao) {
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
      .subscribe((resposta: INotificacao[]) => {
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
