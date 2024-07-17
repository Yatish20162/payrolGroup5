import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Dialog } from '@angular/cdk/dialog';
describe('DialogComponent', () => {
  let component: Dialog;
  let fixture: ComponentFixture<Dialog>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Dialog]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(Dialog);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});