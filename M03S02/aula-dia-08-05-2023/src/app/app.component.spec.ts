import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {  
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;

    expect(app).toBeTruthy();
  });

  it(`should have as title 'aula-dia-08-05-2023'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('aula-dia-08-05-2023');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('aula-dia-08-05-2023 app is running!');
  });

  it(`encontrar o valor 'Resources' no elemento HTML tag <h2>`, () =>{
    const fixture = TestBed.createComponent(AppComponent);
    const compiled = fixture.debugElement.nativeElement.querySelectorAll('h2'); 
    expect(compiled[0]?.textContent).toBe('Resources');
  });

  it(`encontrar o valor 'Next Steps' no elemento HTML tag <h2>`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const compiled = fixture.debugElement.nativeElement.querySelectorAll('h2');
    console.log(compiled);
    expect(compiled[1]?.textContent).toBe('Next Steps');
  });

   it(`encontrar o valor 'Angular Logo' e a largura de 40 em uma imagem`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const compiled = fixture.debugElement.nativeElement.querySelector('img');
   
    expect(compiled.alt).toBe('Angular Logo');
    expect(compiled.width).toEqual(40);
   });

   it(`encontrar o valor 'ng generate component xyz' na Div 'terminal'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.terminal pre')?.textContent).toContain('ng generate component xyz');

   });

});
