import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilUComponent } from './profil-u.component';

describe('ProfilUComponent', () => {
  let component: ProfilUComponent;
  let fixture: ComponentFixture<ProfilUComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilUComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilUComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
