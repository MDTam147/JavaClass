import { Component, Input, OnInit } from '@angular/core';

@Component({
  //selector uses lower case with hyphens.
  selector: 'new-directive',
  template: `<h3>This is the second directive! {{ firstName }}.</h3>
    <third-directive></third-directive>`,
})
export class NewDirectiveComponent implements OnInit {
  @Input() firstName?: string;

  constructor() {}

  ngOnInit(): void {}
}
