import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoTransactionComponent } from './do-transaction.component';

describe('DoTransactionComponent', () => {
  let component: DoTransactionComponent;
  let fixture: ComponentFixture<DoTransactionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoTransactionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
