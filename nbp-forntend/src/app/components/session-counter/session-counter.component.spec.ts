import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionCounterComponent } from './session-counter.component';

describe('SessionCounterComponent', () => {
  let component: SessionCounterComponent;
  let fixture: ComponentFixture<SessionCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SessionCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SessionCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
