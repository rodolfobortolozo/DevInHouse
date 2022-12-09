import { AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, Input, OnChanges, OnDestroy, OnInit, SimpleChange, SimpleChanges } from '@angular/core';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements
  OnInit,
  OnChanges,
  DoCheck,
  AfterContentInit,
  AfterContentChecked,
  AfterViewInit,
  AfterViewChecked,
  OnDestroy
{
  @Input() nomePessoa = '';

  foiPremiado = false;

  ngOnInit(): void {
    console.log('ListComponent foi iniciado');
  }

  ngOnChanges(changes: SimpleChanges): void {
   console.log('ListComponent ngOnChanges', changes);

   if (changes['nomePessoa']?.currentValue === 'José') {
    this.foiPremiado = true;
   } else {
    this.foiPremiado = false;
   }
  }

  ngDoCheck(): void {
   console.log('ListComponent ngDoCheck');
  }

  ngAfterContentInit(): void {
   console.log('ListComponent ngAfterContentInit');
  }

  ngAfterContentChecked(): void {
   console.log('ListComponent ngAfterContentChecked');
  }

  ngAfterViewInit(): void {
   console.log('ListComponent ngAfterViewInit');
  }

  ngAfterViewChecked(): void {
   console.log('ListComponent ngAfterViewChecked');
  }

  ngOnDestroy(): void {
    console.log('ListComponent foi destruído');
  }

  somarNumero(): void {}
}
