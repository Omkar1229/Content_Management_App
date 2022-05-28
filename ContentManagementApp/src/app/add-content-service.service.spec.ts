import { TestBed } from '@angular/core/testing';

import { AddContentServiceService } from './add-content-service.service';

describe('AddContentServiceService', () => {
  let service: AddContentServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddContentServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
