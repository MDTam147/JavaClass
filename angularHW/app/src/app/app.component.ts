import { Component } from '@angular/core';
import { MyDataServiceService } from './my-data-service.service';
import { ConversionCtoFService } from './services/conversion-cto-f.service';

@Component({
  selector: 'app-root',
  template: `<h1>This is the header</h1>
    <nav>
      <a routerLink="/page-a" routerLinkActive="active">A</a> |
      <a routerLink="/page-b/16/tam" routerLinkActive="active">B</a>
    </nav>
    <router-outlet></router-outlet>`,

  // 'providers' allows you to create and pass an instance
  // of the class to the constructor header.
  providers: [ConversionCtoFService],
})
export class AppComponent {
  title = 'This is Angular!';
  names?: Array<any>;
  myName?: string;
  f?: number;
  mydate = new Date(2022, 6, 5, 18, 17, 20);
  price: number = 23.33333;
  celsius!: number;

  constructor(
    myDataService: MyDataServiceService,
    conversion: ConversionCtoFService
  ) {
    this.names = myDataService.getNames();
    this.myName = myDataService.getMyName();

    this.f = conversion.getConversion();
    this.celsius = 33;
  }
}
