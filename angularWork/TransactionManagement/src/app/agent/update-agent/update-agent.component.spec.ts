import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAgentComponent } from './update-agent.component';

describe('UpdateAgentComponent', () => {
  let component: UpdateAgentComponent;
  let fixture: ComponentFixture<UpdateAgentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateAgentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
