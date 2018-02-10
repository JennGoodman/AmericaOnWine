import { TestBed, inject } from '@angular/core/testing';

import { SubTypeService } from './sub-type.service';

describe('SubTypeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SubTypeService]
    });
  });

  it('should be created', inject([SubTypeService], (service: SubTypeService) => {
    expect(service).toBeTruthy();
  }));
});
