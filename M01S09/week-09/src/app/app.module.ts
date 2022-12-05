import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './pages/header/header.component';
import { MainComponent } from './pages/main/main.component';
import { FormsModule } from '@angular/forms';
import { SomaComponent } from './pages/soma/soma.component';
import { AccordionComponent } from './pages/accordion/accordion.component';
import { BotaoComponent } from './pages/botao/botao.component';
import { CalculadoraComponent } from './pages/calculadora/calculadora.component';
import { FormularioCadastroComponent } from './pages/formulario-cadastro/formulario-cadastro.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainComponent,
    SomaComponent,
    AccordionComponent,
    BotaoComponent,
    CalculadoraComponent,
    FormularioCadastroComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
