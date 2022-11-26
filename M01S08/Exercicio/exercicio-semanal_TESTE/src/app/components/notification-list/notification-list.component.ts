import { Component } from '@angular/core';
import { PessoaService } from 'src/app/services/pessoa.service';
import { Pessoa } from 'src/app/models/pessoa';

@Component({
  selector: 'ntap-notification-list',
  templateUrl: './notification-list.component.html',
  styleUrls: ['./notification-list.component.scss'],
})
export class NotificationListComponent {
  pessoa = {} as Pessoa;
  pessoas: Pessoa[] = [];

  constructor(private pessoaService: PessoaService) {}

  ngOnInit() {
    this.getCars();
  }

  getCars() {
    this.pessoaService.getPessoas().subscribe((pessoas: Pessoa[]) => {
      this.pessoas = pessoas;
    });
  }
}
