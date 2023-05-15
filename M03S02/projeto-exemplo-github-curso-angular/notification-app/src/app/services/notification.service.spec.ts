import { TestBed } from '@angular/core/testing'; 
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { NOTIFICATIONS_MOCK } from '../utils/notifications-mock';

import { NotificationService } from "src/app/services/notification.service";
import { HttpClient } from '@angular/common/http';

describe('NotificationService', () =>{
    let httpTestingController: HttpTestingController;  
    let notificationService: NotificationService;
    let httpClient: HttpClient;
 
    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [NotificationService] 
        })
        .compileComponents();  // compila o componente 

         // recupera a instância do controle de teste
         httpTestingController = TestBed.inject(HttpTestingController);
         httpClient = TestBed.inject(HttpClient);

        // recupera NotificationService já configurada com sua dependência (HttpClient)   
        notificationService = TestBed.inject(NotificationService);

      });

        it('Should create component', () => {
            expect(notificationService).toBeDefined();
        });
 
        it('getNotifications - Should call method with success', () => { 
          
            notificationService.getNotifications().subscribe((data) => {
             expect(data).toEqual(NOTIFICATIONS_MOCK);
            }); 
      });

      it('getNotificationsApi - Should call method with success', () => { 
        notificationService.getNotificationsApi().subscribe();

        const req = httpTestingController.expectOne(`${notificationService.BASE_URL}`);
        expect(req.request.method).toEqual('GET');

        // validar solicitações pendentes desta Controller de teste
         httpTestingController.verify();
     });

     it('addNotificationApi - Should call method with success', () => {
        const notificationMock = { message: 'Test notification' };
        notificationService.addNotificationApi(notificationMock).subscribe();

        const req = httpTestingController.expectOne(`${notificationService.BASE_URL}`);
        expect(req.request.method).toEqual('POST');
        expect(req.request.body).toEqual(notificationMock);

         // validar solicitações pendentes desta Controller de teste
         httpTestingController.verify();
     });

     it('editNotificationApi - Should call method with success', () => {
        const notificationMock = {id: 1, message: 'Test notification' };
        notificationService.editNotificationApi(notificationMock).subscribe();

        const req = httpTestingController.expectOne(`${notificationService.BASE_URL}/${notificationMock.id}`);
        expect(req.request.method).toEqual('PUT');
        expect(req.request.body).toEqual(notificationMock);

         // validar solicitações pendentes desta Controller de teste
         httpTestingController.verify();
    
     });

     it('removeNotification - Should call method with success', () => {
        const notificationMock = {id: 1, message: 'Test notification' };
        notificationService.removeNotification(notificationMock.id).subscribe();

        const req = httpTestingController.expectOne(`${notificationService.BASE_URL}/${notificationMock.id}`);
        expect(req.request.method).toEqual('DELETE'); 

         // validar solicitações pendentes desta Controller de teste
         httpTestingController.verify();
     }); 
});