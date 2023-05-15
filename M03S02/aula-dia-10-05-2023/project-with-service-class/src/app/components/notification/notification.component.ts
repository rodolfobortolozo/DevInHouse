import { Component, EventEmitter, Output } from '@angular/core';
import { INotification } from 'src/app/models/notification.model';
import { NotificationService } from 'src/app/services/notification.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent {
  novaNotificacao: INotification = {
    titulo: '',
    descricao: '',
    aplicativo: 'IFOOD',
    tempoPublicacao: 'Agora',
    imagem: 'assets/images/ifood.png',
    lido: false
  }

  @Output()
  notificacaoCadastrada = new EventEmitter<void>();

  constructor(private notificationService: NotificationService) {
  }

  enviarForm() {
    this.notificationService
      .addNotificationApi(this.novaNotificacao)
      .subscribe(() => {
        this.notificacaoCadastrada.emit();
      });
  }
}