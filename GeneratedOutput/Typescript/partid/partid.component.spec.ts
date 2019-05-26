import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PartidComponent } from './partid.component';

describe('PartidComponent', () => {
  let component: PartidComponent;
  let fixture: ComponentFixture<PartidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PartidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PartidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
