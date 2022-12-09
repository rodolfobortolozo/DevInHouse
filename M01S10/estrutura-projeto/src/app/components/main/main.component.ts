import { Component } from '@angular/core';

@Component({
  selector: 'philips-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  pessoa = {
    nome: 'Kelvis',
    profissao: 'Desenvolvedor'
  }
  pessoas = [
    {
      nome: 'Fernanda',
      profissao: 'Product Designer'
    },
    {
      nome: 'João',
      profissao: 'Desenvolvedor'
    },
    {
      nome: 'Maria',
      profissao: 'Desenvolvedor'
    },
    {
      nome: 'Fernanda',
      profissao: 'Product Designer'
    },
    {
      nome: 'João',
      profissao: 'Desenvolvedor'
    },
    {
      nome: 'Maria',
      profissao: 'Desenvolvedor'
    },
    {
      nome: 'Fernanda',
      profissao: 'Product Designer'
    },
    {
      nome: 'João',
      profissao: 'Desenvolvedor'
    },
    {
      nome: 'Maria',
      profissao: 'Desenvolvedor'
    },
    {
      nome: 'Fernanda',
      profissao: 'Product Designer'
    },
    {
      nome: 'João',
      profissao: 'Desenvolvedor'
    },
    {
      nome: 'Maria',
      profissao: 'Desenvolvedor'
    },
    {
      nome: 'Fernanda',
      profissao: 'Product Designer'
    },
    {
      nome: 'João',
      profissao: 'Desenvolvedor'
    },
    {
      nome: 'Maria',
      profissao: 'Desenvolvedor'
    },
  ];

  salvarPessoa() {
    console.log('Salvo com sucesso!');
  }
}
