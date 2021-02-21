import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RandomPopUpComponent } from './random-pop-up.component';

describe('RandomPopUpComponent', () => {
  let component: RandomPopUpComponent;
  let fixture: ComponentFixture<RandomPopUpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RandomPopUpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RandomPopUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
