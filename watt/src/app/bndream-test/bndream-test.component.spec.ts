import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BndreamTestComponent } from './bndream-test.component';

describe('BndreamTestComponent', () => {
  let component: BndreamTestComponent;
  let fixture: ComponentFixture<BndreamTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BndreamTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BndreamTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
