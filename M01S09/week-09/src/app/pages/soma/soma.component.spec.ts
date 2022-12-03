import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SomaComponent } from './soma.component';

describe('SomaComponent', () => {
  let component: SomaComponent;
  let fixture: ComponentFixture<SomaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SomaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SomaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
