import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticalMeasureComponent } from './statistical-measure.component';

describe('StatisticalMeasureComponent', () => {
  let component: StatisticalMeasureComponent;
  let fixture: ComponentFixture<StatisticalMeasureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatisticalMeasureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatisticalMeasureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
