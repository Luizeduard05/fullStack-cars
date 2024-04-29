import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardsCarComponent } from './cards-car.component';

describe('CardsCarComponent', () => {
  let component: CardsCarComponent;
  let fixture: ComponentFixture<CardsCarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CardsCarComponent]
    });
    fixture = TestBed.createComponent(CardsCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
