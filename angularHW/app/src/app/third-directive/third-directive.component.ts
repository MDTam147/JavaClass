import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'third-directive',
  template: '<h3>Hello from the third directive</h3>',
})
export class ThirdDirectiveComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
}
