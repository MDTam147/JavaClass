import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NewDirectiveComponent } from './new-directive/new-directive.component';
import { ThirdDirectiveComponent } from './third-directive/third-directive.component';
import { SecondDirectiveComponent } from './second-directive/second-directive.component';
import { FahrenheitPipe } from './fahrenheit.pipe';
import { PhoneFormatPipe } from './phone-format.pipe';
import { PageAComponent } from './page-a/page-a.component';
import { PageBComponent } from './page-b/page-b.component';
import { PageDefaultComponent } from './page-default/page-default.component';
import { routing } from './app.routing';
import { FormsModule } from '@angular/forms';
import { NgModel } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NewDirectiveComponent,
    ThirdDirectiveComponent,
    SecondDirectiveComponent,
    FahrenheitPipe,
    PhoneFormatPipe,
    PageAComponent,
    PageBComponent,
    PageDefaultComponent,
  ],
  imports: [BrowserModule, routing, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
