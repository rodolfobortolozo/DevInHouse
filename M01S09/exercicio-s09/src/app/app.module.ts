import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SubjectsRegistryComponent } from './components/subjects-registry/subjects-registry.component';
import { SendFormButtonComponent } from './components/subjects-registry/send-form-button/send-form-button.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { ItemCardComponent } from './components/item-card/item-card.component';

@NgModule({
  declarations: [
    AppComponent,
    SubjectsRegistryComponent,
    SendFormButtonComponent,
    NavbarComponent,
    HomeComponent,
    ItemCardComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
