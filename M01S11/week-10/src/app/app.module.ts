import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormataCpf } from './formata-cpf.pipe';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent, AppComponent, FormataCpf],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
