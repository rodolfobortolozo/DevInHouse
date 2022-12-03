import { Component } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
})
export class MainComponent {
  name: string = 'Rodolfo';
  idade: number = 0;
  type: string = 'text';

  valor: number = 0;
}
