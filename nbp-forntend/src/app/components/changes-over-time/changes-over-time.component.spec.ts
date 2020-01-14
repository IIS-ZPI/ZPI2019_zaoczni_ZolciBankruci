import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangesOverTimeComponent } from './changes-over-time.component';

describe('ChangesOverTimeComponent', () => {
  let component: ChangesOverTimeComponent;
  let fixture: ComponentFixture<ChangesOverTimeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangesOverTimeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangesOverTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
