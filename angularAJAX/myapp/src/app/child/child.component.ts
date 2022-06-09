import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'child',
  template: ` <table>
    <tr>
      <td>Street Address:</td>
      <td>&nbsp;&nbsp;</td>
      <td><input type="text" [(ngModel)]="streetAddress" /></td>
    </tr>
    <tr>
      <td>City:</td>
      <td>&nbsp;&nbsp;</td>
      <td><input type="text" [(ngModel)]="city" /></td>
    </tr>
    <tr>
      <td>Region:</td>
      <td>&nbsp;&nbsp;</td>
      <td><input type="text" [(ngModel)]="region" /></td>
    </tr>
    <tr>
      <td></td>
      <td></td>
      <td><input type="submit" (click)="submitInput()" /></td>
    </tr>
  </table>`,
})
export class ChildComponent implements OnInit {
  streetAddress!: string;
  @Input() city!: string;
  @Input() callParent!: Function; //Reference to parent function, ref provided by parent.
  region!: string;

  constructor() {}

  ngOnInit(): void {}

  submitInput() {
    this.callParent(this.streetAddress, this.city, this.region);
  }
}
