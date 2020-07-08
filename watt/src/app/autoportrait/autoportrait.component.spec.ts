import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoportraitComponent } from './autoportrait.component';

describe('AutoportraitComponent', () => {
  let component: AutoportraitComponent;
  let fixture: ComponentFixture<AutoportraitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoportraitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoportraitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
