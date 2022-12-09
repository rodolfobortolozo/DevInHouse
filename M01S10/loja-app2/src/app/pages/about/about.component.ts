import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'lja-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {
  itemEscolhido = '';

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    console.log('ngOnInit AboutComponent');

    // console.log('Parametros: ', this.route.snapshot.params);
    // this.itemEscolhido = this.route.snapshot.params['produto'];
    this.route.params.subscribe((params) => {
      console.log('Parametros: ', params);
      this.itemEscolhido = params['produto'];
    });
  }
}
