import { TestBed } from '@angular/core/testing';

import { ConnectorAgentService } from './connector-agent.service';

describe('ConnectorAgentService', () => {
  let service: ConnectorAgentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConnectorAgentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
