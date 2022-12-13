import { Component } from '@angular/core';
import { FormataCpf } from './formata-cpf.pipe';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'week-10';
  cpf = '366817168812';
}
