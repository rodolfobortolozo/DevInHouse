import { Component } from '@angular/core';

@Component({
  selector: 'philips-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent {
  pessoa = {
    nome: 'Rodolfo',
    sobrenome: 'Bortolozo',
  };

  pessoas = [
    {
      nome: 'Fernanda',
      profissao: 'Product Designer',
    },
    {
      nome: 'João',
      profissao: 'Desenvolvedor',
    },
    {
      nome: 'Maria',
      profissao: 'Desenvolvedor',
    },
  ];

  funcaoTeste() {
    return alert('Rodolfo');
  }
}
