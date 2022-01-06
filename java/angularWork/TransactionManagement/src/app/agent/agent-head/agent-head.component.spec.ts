import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentHeadComponent } from './agent-head.component';

describe('AgentHeadComponent', () => {
  let component: AgentHeadComponent;
  let fixture: ComponentFixture<AgentHeadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgentHeadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentHeadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
