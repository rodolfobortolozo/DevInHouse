import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NotificationListComponent } from './notification-list/notification-list.component';
import { ListGroupItemComponent } from './list-group-item/list-group-item.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { ButtonsComponent } from './buttons/buttons.component'; //Importo a clase HttpClientModule
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { NotfoundComponent } from './notfound/notfound.component';

const ROUTES: Routes = [
  {
    path: '',
    component: ListGroupItemComponent,
  },
  {
    path: 'inicio',
    component: ListGroupItemComponent,
  },
  {
    path: 'inicio/:status',
    component: ListGroupItemComponent,
  },
  {
    path: 'sobre',
    component: AboutComponent,
  },
  {
    path: '**',
    component: NotfoundComponent,
  },
];

@NgModule({
  declarations: [
    AppComponent,
    NotificationListComponent,
    ListGroupItemComponent,
    HeaderComponent,
    FooterComponent,
    ButtonsComponent,
    AboutComponent,
    NotfoundComponent,
  ],
  imports: [BrowserModule, HttpClientModule, RouterModule.forRoot(ROUTES)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
