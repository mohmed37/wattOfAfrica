import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoueVieComponent } from './roue-vie.component';

describe('RoueVieComponent', () => {
  let component: RoueVieComponent;
  let fixture: ComponentFixture<RoueVieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoueVieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoueVieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
