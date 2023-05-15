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

  it(`should have as title 'projeto-exemplo-01'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('projeto-exemplo-01');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('projeto-exemplo-01 app is running!');
  });

  it(`should have a value 'Resources' in HTML tag h2`, () => {
    const fixture  =TestBed.createComponent(AppComponent);   
    const compiled = fixture.debugElement.nativeElement.querySelectorAll('h2');
    expect(compiled[0]?.textContent).toBe('Resources');
  });

  it(`should have a value 'Next Steps' in HTML tag h2`, () => {
    const fixture  =TestBed.createComponent(AppComponent); 
    const compiled = fixture.debugElement.nativeElement.querySelectorAll('h2');
    expect(compiled[1]?.textContent).toBe('Next Steps');
  });

  it(`should have a image alt value 'Angular Logo'`, () => {
    const fixture  =TestBed.createComponent(AppComponent); 
    const compiled = fixture.debugElement.nativeElement.querySelector('img');  
    expect(compiled.alt).toBe('Angular Logo');
  });

  it(`should have ngSwitchCase element with 5 values'`, () => {
    const fixture  =TestBed.createComponent(AppComponent); 
    fixture.detectChanges();
    const compiled =  HTMLElement = fixture.nativeElement;
    expect(compiled.querySelector('.terminal pre').innerText).toBe('ng generate component xyz');    
  });
});
