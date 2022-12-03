import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-botao',
  templateUrl: './botao.component.html',
  styleUrls: ['./botao.component.scss'],
})
export class BotaoComponent {
  @Input() tipo: string = '';
  @Input() texto: String = '';
  @Input() classe: string = '';

  @Output() actionOutput: EventEmitter<any> = new EventEmitter();
  executeFunction() {
    this.actionOutput.emit('Rodolfo aaaaaaaaa');
  }
}
