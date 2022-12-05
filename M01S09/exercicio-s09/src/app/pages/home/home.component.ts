import { Component } from '@angular/core';
import { CHARACTERS } from 'src/app/constants/item-card/characters';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  characters = CHARACTERS;
}
