import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionHeadComponent } from './transaction-head.component';

describe('TransactionHeadComponent', () => {
  let component: TransactionHeadComponent;
  let fixture: ComponentFixture<TransactionHeadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransactionHeadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionHeadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
