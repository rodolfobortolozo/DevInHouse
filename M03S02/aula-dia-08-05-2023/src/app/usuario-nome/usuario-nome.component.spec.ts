import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioNomeComponent } from './usuario-nome.component';

describe('UsuarioNomeComponent', () => {
  let component: UsuarioNomeComponent;
  let fixture: ComponentFixture<UsuarioNomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsuarioNomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuarioNomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
