import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientHeadComponent } from './client-head.component';

describe('ClientHeadComponent', () => {
  let component: ClientHeadComponent;
  let fixture: ComponentFixture<ClientHeadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientHeadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientHeadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
