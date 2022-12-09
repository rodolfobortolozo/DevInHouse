import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanDeactivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { LoginComponent } from '../pages/login/login.component';

@Injectable({
  providedIn: 'root'
})
export class BloqueadorGuard implements CanActivate, CanDeactivate<AppComponent> {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    // Vou criar a lógica específica para decidir se o usuario pode acessar a rota / continuar acesso
    console.log('Route : ', route);
    console.log('State : ', state);

    return true;
  }

  canDeactivate(
    component: AppComponent,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState: RouterStateSnapshot
  ): boolean {
    // Vou criar a lógica específica para decidir se o usuario pode sair da rota / continuar acesso
    console.log('Route : ', currentRoute);
    console.log('State : ', currentState);

    return true;
  }

}
