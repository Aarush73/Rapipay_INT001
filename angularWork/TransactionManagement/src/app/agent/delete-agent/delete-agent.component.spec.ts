import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteAgentComponent } from './delete-agent.component';

describe('DeleteAgentComponent', () => {
  let component: DeleteAgentComponent;
  let fixture: ComponentFixture<DeleteAgentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteAgentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
