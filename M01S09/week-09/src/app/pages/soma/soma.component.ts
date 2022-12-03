import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-soma',
  templateUrl: './soma.component.html',
  styleUrls: ['./soma.component.scss'],
})
export class SomaComponent {
  @Input() infoText: String = '';

  valor: number = 0;

  somar() {
    this.valor++;
    this.verifica();
  }

  subtrair() {
    this.valor--;
    this.verifica();
  }

  verifica(): boolean {
    if (this.valor >= 0) {
      return true;
    }
    return false;
  }
}
