import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotificationComponent } from './notification.component';
import { AppModule } from 'src/app/app.module';
import { NotificationService } from 'src/app/services/notification.service';
import { INotification } from 'src/app/models/notification.model';
import { of } from 'rxjs';

describe('NotificationComponent', () => {
  let component: NotificationComponent;
  let fixture: ComponentFixture<NotificationComponent>;
  let notificationService = jasmine.createSpyObj(
                              NotificationService, 
                              ['addNotificationApi' ]);

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotificationComponent ],
      imports: [AppModule],
      providers: [{provide: NotificationService, useValue: notificationService}]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('enviarForm - dee enviar o formulário com sucesso', () => {
    const  novaNotificacao: INotification = {
      titulo: '',
      descricao: '',
      aplicativo: 'IFOOD',
      tempoPublicacao: 'Agora',
      imagem: 'assets/images/ifood.png',
      lido: false
    }
     
    notificationService.addNotificationApi.and.returnValue(of({novaNotificacao}));
    spyOn(component.notificacaoCadastrada, 'emit');
    component.enviarForm();

    expect(notificationService.addNotificationApi).toHaveBeenCalledOnceWith(novaNotificacao);
    expect(component.notificacaoCadastrada.emit).toHaveBeenCalled();

  });
});
