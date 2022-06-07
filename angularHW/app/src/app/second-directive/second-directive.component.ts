import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'second-directive',
  template: `<h3>This is the second directive!</h3>
    <third-directive></third-directive>`,
})
export class SecondDirectiveComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
}
