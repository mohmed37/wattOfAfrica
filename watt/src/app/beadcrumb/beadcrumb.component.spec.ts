import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BeadcrumbComponent } from './beadcrumb.component';

describe('BeadcrumbComponent', () => {
  let component: BeadcrumbComponent;
  let fixture: ComponentFixture<BeadcrumbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BeadcrumbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BeadcrumbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
