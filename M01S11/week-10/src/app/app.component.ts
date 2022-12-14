import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'week-10';
  cpf = '366817168812';
  nome: number = 1;

  verImagem: string = '';
  verImagem2: string = '';
  verImagem3: string = '';

  listaDeTarefas = [
    {
      id: 1,
      tarefa: 'Limpar Quarto',
    },
    {
      id: 2,
      tarefa: 'Estudar',
    },
    {
      id: 3,
      tarefa: 'Lavar a Louça  ',
    },
    {
      id: 4,
      tarefa: 'Limpar Quarto',
    },
    {
      id: 5,
      tarefa: 'Estudar',
    },
    {
      id: 6,
      tarefa: 'Lavar a Louça  ',
    },
  ];

  expression() {
    return false;
  }
}
