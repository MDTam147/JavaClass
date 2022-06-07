import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  template: `This is page b. {{ retrievedFromStorage }}
    <input
      type="input"
      (ngModelChange)="myChange($event)"
      [ngModel]="mymodel"
    />
    <input
      type="input"
      (ngModelChange)="myChange2($event)"
      [ngModel]="mymodel2"
    />`,
})
export class PageBComponent implements OnInit {
  id!: number;
  firstname!: string;
  mymodel: any = 'model';
  mymodel2: any = 'model2';
  retrievedFromStorage: string | null = sessionStorage.getItem('your key');

  constructor(private route: ActivatedRoute) {
    let str = 'This is where the class is initialized!';
    console.log(str);
  }

  myChange(val: string) {
    sessionStorage.setItem('autosave', val);
    console.log(val);
  }

  myChange2(val2: string) {
    sessionStorage.setItem('autosave2', val2);
    console.log(val2);
  }

  ngOnInit() {
    this.route.params.forEach((param: Params) => {
      let localID = param['id'];
      let localName = param['firstname'];
      this.id = localID;
      this.firstname = localName;
    });
  }
}
