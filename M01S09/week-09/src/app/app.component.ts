import { Component, Input } from '@angular/core';
import { GeneralService } from './services/general.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'week-09';
  title1: string = 'Week-09';
  descripton: string =
    'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using Content here, content here, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for lorem ipsum will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).';

  classe = 'btn btn-primary';
  tipo = 'submit';
  texto = 'Sucesso';

  action() {
    console.log('Rodolfo 123');
  }

  constructor(private general: GeneralService, private ge: GeneralService) {}

  // ngOnInit(): void {
  //   console.log(this.ge.somar(1, 3));
  // }
}
