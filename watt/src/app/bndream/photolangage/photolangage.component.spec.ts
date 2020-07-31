import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhotolangageComponent } from './photolangage.component';

describe('PhotolangageComponent', () => {
  let component: PhotolangageComponent;
  let fixture: ComponentFixture<PhotolangageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhotolangageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhotolangageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
