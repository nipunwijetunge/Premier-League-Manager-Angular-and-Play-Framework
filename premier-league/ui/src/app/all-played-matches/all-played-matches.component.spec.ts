import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPlayedMatchesComponent } from './all-played-matches.component';

describe('AllPlayedMatchesComponent', () => {
  let component: AllPlayedMatchesComponent;
  let fixture: ComponentFixture<AllPlayedMatchesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllPlayedMatchesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllPlayedMatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
