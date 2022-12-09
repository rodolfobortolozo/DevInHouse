import { Component, OnInit } from '@angular/core';
import { INotificacao } from 'src/app/models/notificacao.model';
import { NOTIFICATIONS_MOCK } from 'src/app/utils/notifications-mock';

@Component({
  selector: 'ntap-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.scss'],
})
export class ContentComponent implements OnInit {
  listaDeNotificacoes: INotificacao[] = [];

  ngOnInit(): void {
    this.listaDeNotificacoes = NOTIFICATIONS_MOCK;
  }

  lerNotificacao(indice: number) {
    console.log('indice', indice);

    this.listaDeNotificacoes.forEach((item, index) => {
      if (index === indice) {
        item.lido = true;
      }

      return item;
    });
  }
}
