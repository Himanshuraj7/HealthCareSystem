import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAppointmemtComponent } from './view-appointmemt.component';

describe('ViewAppointmemtComponent', () => {
  let component: ViewAppointmemtComponent;
  let fixture: ComponentFixture<ViewAppointmemtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAppointmemtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAppointmemtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
