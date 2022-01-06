import { TestBed } from '@angular/core/testing';

import { ConnectorTransactionService } from './connector-transaction.service';

describe('ConnectorTransactionService', () => {
  let service: ConnectorTransactionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConnectorTransactionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
