import { AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, OnChanges, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements
  OnInit,
  OnChanges,
  DoCheck,
  AfterContentInit,
  AfterContentChecked,
  AfterViewInit,
  AfterViewChecked
  {

  nomePessoaPai = 'Maria';
  temPermissao = true;

  ngOnInit(): void {
    console.log('AppComponent foi iniciado');

    setTimeout(() => {
      this.nomePessoaPai = 'Eduardo';
    }, 3000);

    setTimeout(() => {
      this.nomePessoaPai = 'José';
    }, 7000);

    setTimeout(() => {
      this.temPermissao = false;
    }, 9000);
  }

  ngOnChanges(): void {
   console.log('AppComponent ngOnChanges');
  }

  ngDoCheck(): void {
   console.log('AppComponent ngDoCheck');
  }

  ngAfterContentInit(): void {
   console.log('AppComponent ngAfterContentInit');
  }

  ngAfterContentChecked(): void {
   console.log('AppComponent ngAfterContentChecked');
  }

  ngAfterViewInit(): void {
   console.log('AppComponent ngAfterViewInit');
  }

  ngAfterViewChecked(): void {
   console.log('AppComponent ngAfterViewChecked');
  }


  // botaoFilhoPrimario(nome: string) {
  //   console.log(`${nome} Inserido Com Sucesso!!!`);
  // }

  // botaoFilhoSecundario(nome: string) {
  //   console.log(`${nome} Deletada Com Sucesso!!!`);
  // }
}
