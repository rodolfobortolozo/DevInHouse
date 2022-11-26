import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NotificationListComponent } from './components/notification-list/notification-list.component';
import { ListGroupItemComponent } from './components/list-group-item/list-group-item.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http'; //Importo a clase HttpClientModule

@NgModule({
  declarations: [
    AppComponent,
    NotificationListComponent,
    ListGroupItemComponent,
    HeaderComponent,
    FooterComponent,
  ],
  imports: [BrowserModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
