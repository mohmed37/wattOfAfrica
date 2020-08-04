import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BndreamComponent } from './bndream.component';

describe('BndreamComponent', () => {
  let component: BndreamComponent;
  let fixture: ComponentFixture<BndreamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BndreamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BndreamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
