import { Component, EventEmitter, Output } from '@angular/core';
import { INotificacao } from 'src/app/models/notificacao.model';
import { NotificationService } from 'src/app/services/notification.service';

@Component({
  selector: 'ntap-notification-add',
  templateUrl: './notification-add.component.html',
  styleUrls: ['./notification-add.component.scss']
})
export class NotificationAddComponent {
  novaNotificacao: INotificacao = {
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

  teste(formulario: any) {
    console.log('formulario', formulario);
    return true;
  }
}
