import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'ntap-buttons',
  templateUrl: './buttons.component.html',
  styleUrls: ['./buttons.component.scss'],
})
export class ButtonsComponent {
  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    console.log('ngOnInit AboutComponent');

    // console.log('Parametros: ', this.route.snapshot.params);
    // this.itemEscolhido = this.route.snapshot.params['produto'];
    this.route.params.subscribe((params) => {
      console.log('Parametros: ', params['status']);
      // this.itemEscolhido = params['produto'];
    });
  }
}
