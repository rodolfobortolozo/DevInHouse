import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-button-actions',
  templateUrl: './button-actions.component.html',
  styleUrls: ['./button-actions.component.scss']
})
export class ButtonActionsComponent {
  @Input() tituloBotaoPrimario: string = 'Salvar';
  @Input() tituloBotaoSecundario: string = 'Cancelar';

  @Output()
  botaoPrimarioClicado = new EventEmitter<string>();

  @Output()
  botaoSegundarioClicado = new EventEmitter<string>();

  dispararPrimario() {
    console.log('ButtonActionsComponent Clique dispararPrimario');
    this.botaoPrimarioClicado.emit('João');
  }

  dispararSegundario() {
    console.log('ButtonActionsComponent Clique dispararSegundario');
    this.botaoSegundarioClicado.emit('Maria');
  }
}
