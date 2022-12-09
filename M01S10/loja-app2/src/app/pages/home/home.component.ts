import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'lja-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  nomePessoa = '';
  sobrenomePessoa = '';

  apelido = '';
  idade = 0;

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    // console.log('Parametros: ', this.route.snapshot.params);
    // this.nomePessoa = this.route.snapshot.params['nome']
    // this.sobrenomePessoa = this.route.snapshot.params['sobrenome']

    console.log('Parametros via QueryParams: ', this.route.snapshot.queryParams);
    this.apelido = this.route.snapshot.queryParams['apelido'];
    this.idade = this.route.snapshot.queryParams['idade'];
  }
}
