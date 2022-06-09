import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HighlightDirective } from './highlight.directive';

@Component({
  selector: 'app-root',
  templateUrl: `./app.component.html`,
})
export class AppComponent {
  title = 'myapp';
  namesArray!: Array<any>;
  _http: HttpClient;

  parentFuncRef!: Function;
  operations?: Array<any>;
  dataFromChild!: string;
  city!: string;

  cutContent = '';
  myPastedContent = '';

  color = 'lightgreen';

  // Since we are using a provider above, we can receive
  // an instance through an instructor.

  constructor(private http: HttpClient) {
    this._http = http;
  }

  // This function is called by the Angular framework after
  // this constructor executes.
  public ngOnInit() {
    this.parentFuncRef = this.myCallBackFunction.bind(this);
  }

  getSomeData() {
    this._http
      .get<any>('./assets/test.json')
      // Get data and wait for result.
      .subscribe(
        (result) => {
          this.namesArray = result;
        },

        (error) => {
          // Let user know about the error.
          alert(error);
          console.error(error);
        }
      );
  }

  // This function can be called by child.
  public myCallBackFunction(
    streetAddress: string,
    city: string,
    region: string
  ) {
    this.dataFromChild =
      'Street Address: ' +
      streetAddress +
      ' ' +
      ' Region: ' +
      region +
      ' City: ' +
      city;
  }

  myMouseEnter() {
    console.log('Mouse entered!');
  }

  myMouseLeave() {
    console.log('Mouse left!');
  }

  // captures all key down presses in the input box and displays to console
  myKeyDown(event: { key: any }) {
    console.log(event);
    console.log(event.key);
  }

  myKeyUp(event: { key: any }) {
    console.log(event);
    console.log(event.key);
  }

  myFocusEvent(description: string) {
    console.log(description);
  }

  cutEvent(content: string) {
    this.cutContent = content;
    console.log(this.cutContent);
  }
  pasteContent() {
    console.log(this.cutContent);
    this.cutContent = '';
  }

  myMouseHandler(
    event: {
      screenX: { toString: () => string };
      screenY: { toString: () => string };
    },
    description: string
  ) {
    console.log(
      description +
        ' X: ' +
        event.screenX.toString() +
        ' Y: ' +
        event.screenY.toString()
    );
  }

  myMouseMove(event: MouseEvent) {
    console.log(
      'Mouse is moving --- X: ' +
        event.screenX.toString() +
        ' Y: ' +
        event.screenY.toString()
    );
  }
}
