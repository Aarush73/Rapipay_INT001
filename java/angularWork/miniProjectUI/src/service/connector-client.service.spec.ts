import { TestBed } from '@angular/core/testing';

import { ConnectorClientService } from './connector-client.service';

describe('ConnectorClientService', () => {
  let service: ConnectorClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConnectorClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
