import { TestBed, inject } from '@angular/core/testing';

import { AccountAccessService } from './account-access.service';

describe('AccountAccessService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AccountAccessService]
    });
  });

  it('should be created', inject([AccountAccessService], (service: AccountAccessService) => {
    expect(service).toBeTruthy();
  }));
});
