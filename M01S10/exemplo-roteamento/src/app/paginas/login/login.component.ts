import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  tituloPagina = 'Página de Login';

  ngOnInit(): void {
    setTimeout(() => {
      this.tituloPagina = 'LOGAR';
    }, 4000);
  }

}
