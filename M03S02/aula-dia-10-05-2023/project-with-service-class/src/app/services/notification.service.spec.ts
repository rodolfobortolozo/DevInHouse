import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { NotificationService } from './notification.service';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NOTIFICATIONS_MOCK } from '../utils/notifications-mock';

describe('NotificationService', () => { 
  let httpTestingController: HttpTestingController;
  let notificationService: NotificationService;
  let httpClient: HttpClient;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [NotificationService]
    }).compileComponents();

     httpTestingController = TestBed.inject(HttpTestingController);
     httpClient = TestBed.inject(HttpClient);
     notificationService = TestBed.inject(NotificationService);
    
  });

  it('should be created', () => {
    expect(notificationService).toBeTruthy();
  });

  it('getNotifications - deve retornar uma lista de Notificações', () => {

    notificationService.getNotifications().subscribe((retorno) => {
      expect(retorno).toEqual(NOTIFICATIONS_MOCK);
    });
  });

 
    it('getNotificationsApi - deve executar o método com sucesso', () => {
      notificationService.getNotificationsApi().subscribe();
  
       const resultado = httpTestingController.expectOne(`${notificationService.BASE_URL}`);
   
       expect(resultado.request.method).toEqual('GET');
    });
  
     it('addNotificationApi - deve adicionar um objeto com sucesso', () =>{
      const parametro = 'valor 1';
      notificationService.addNotificationApi(parametro).subscribe();
  
      const resultado = httpTestingController.expectOne(`${notificationService.BASE_URL}`);
  
      expect(resultado.request.method).toEqual('POST');
      expect(resultado.request.body).toEqual(parametro);
     });
 
  
  it('editNotificationApi - deve atualizar os dados com sucesso', () => {
    const parametro = {id: 1, valor: 'Aula Teste Angular', ativo: true};
    notificationService.editNotificationApi(parametro).subscribe();

    const resultado = httpTestingController.expectOne(`${notificationService.BASE_URL}/${parametro.id}`);
    expect(resultado.request.method).toEqual('PUT');
    expect(resultado.request.body).toEqual(parametro);
  });

  it('removeNotification - deve remover um registro com sucesso', () => {
    const parametro = {id: 1, valor: 'Aula Teste Angular', ativo: true};
    notificationService.removeNotification(parametro.id).subscribe();
   
    const resultado = httpTestingController.expectOne(`${notificationService.BASE_URL}/${parametro.id}`);
    expect(resultado.request.method).toEqual('DELETE');

  });
  
});
