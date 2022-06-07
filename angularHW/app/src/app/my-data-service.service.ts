import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class MyDataServiceService {
  names?: Array<any>;
  myName?: string;

  constructor() {
    this.names = ['Tam', 'Maria', 'Doan'];
    this.myName = 'Maria';
  }

  getNames() {
    return this.names;
  }

  getMyName() {
    return this.myName;
  }
}
