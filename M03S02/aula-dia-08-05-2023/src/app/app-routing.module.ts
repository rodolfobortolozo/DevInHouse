import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { UsuarioNomeComponent } from './usuario-nome/usuario-nome.component';

const routes: Routes = [ {
  path: 'home',
  component: AppComponent
},
{
  path: 'usuario-nome',
  component: UsuarioNomeComponent
},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
