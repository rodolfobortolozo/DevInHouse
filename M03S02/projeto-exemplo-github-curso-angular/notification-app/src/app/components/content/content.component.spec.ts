import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from "rxjs";

import { NOTIFICATIONS_MOCK } from '../../utils/notifications-mock';
import { AppModule } from "src/app/app.module";
import { ContentComponent } from "./content.component";
import { NotificationService } from "src/app/services/notification.service";

describe('ContentComponent', () =>{
    let fixture: ComponentFixture<ContentComponent>;
    let component:ContentComponent;
    let notificationService =  jasmine.createSpyObj(NotificationService, ['editNotificationApi', 'getNotifications', 'removeNotification']);

    beforeEach(async () => {
        await TestBed.configureTestingModule({
          imports: [AppModule],
          declarations: [ContentComponent],
          providers: [ { provide: NotificationService, useValue: notificationService } ]
        })
        .compileComponents();  // compila o componente (html, ts e css)

         //criação do componente ContentComponent para realização dos testes
         fixture = TestBed.createComponent(ContentComponent);
         component = fixture.componentInstance;

      });
 

        it('Should create component', () => {
            expect(component).toBeTruthy();
        });
 
    describe('submit', () =>{
        it('ngOnInit - Should call carregarNotificacoes method with success', () =>{
            spyOn(component, 'carregarNotificacoes');
            component.ngOnInit();

            expect(component.carregarNotificacoes).toHaveBeenCalled();
        }); 

        it('lerNotificacao - Should call atualizarLista method with success', () => {
            spyOn(component, 'atualizarLista');
            const notificacaoMock =  {aplicativo: '', titulo:'', descricao: '', tempoPublicacao: '',
                                    imagem: '', lido: false, id: 1};
            const notificacaoEditadaMock = { ...notificacaoMock, lido: true};      
            notificationService.editNotificationApi.and.returnValue(of({}));            
            
            component.lerNotificacao(notificacaoMock);

            expect(notificationService.editNotificationApi).toHaveBeenCalledWith(notificacaoEditadaMock);
            expect(component.atualizarLista).toHaveBeenCalled();
        });
    });
   
        it('atualizarLista - Should call carregarNotificacoes method with success', () => {
            spyOn(component, 'carregarNotificacoes');             
             component.atualizarLista();
  
             expect(component.carregarNotificacoes).toHaveBeenCalled();
         });
  
        it('carregarNotificacoes - Should return values to listaDeNotificacoes with success', () => {
           notificationService.getNotifications.and.returnValue(of( NOTIFICATIONS_MOCK));      
           component.carregarNotificacoes();
     
           expect(notificationService.getNotifications).toHaveBeenCalled(); 
           expect(component.listaDeNotificacoes).toEqual(NOTIFICATIONS_MOCK);   
        });

        it('removerNotificacao - Should call atualizarLista method with success', () => {
            spyOn(component, 'atualizarLista');
            
            notificationService.removeNotification.and.returnValue(of({}));            
            
            component.removerNotificacao(1);

            expect(notificationService.removeNotification).toHaveBeenCalled();
            expect(component.atualizarLista).toHaveBeenCalled(); 
         });
});
 