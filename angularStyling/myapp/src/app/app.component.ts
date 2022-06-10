import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<h1>Changing colors with checkbox</h1>
    <label [class.danger]="foodWarning">Has food allergy.</label>
    <input type="checkbox" [(ngModel)]="foodWarning" />
    <label [class.makeGreen]="greenChecked">Make me green</label>
    <input type="checkbox" [(ngModel)]="greenChecked" />
    <h1>Applying multiple CSS class with [ngClass]</h1>
    <p [ngClass]="myClasses">class binding example</p>
    <h1>Adjusting CSS with ngModel</h1>
    <input
      type="checkbox"
      [(ngModel)]="doesNotExercise"
      (change)="adjustCSS()"
    />Does not exercise.
    <input type="checkbox" [(ngModel)]="over55" (change)="adjustCSS()" />Is over
    55
    <div *ngIf="doesNotExercise || over55" [ngClass]="myClasses_2">
      Is at risk of heart disease.
    </div>
    <h1>ngStyle</h1>
    <p [ngStyle]="myStyles">style binding example</p>
    <h1>Binding one style at a time</h1>
    <p [style.font-weight]="myWeight">style binding example</p>`,

  styles: [
    `
      .danger {
        color: orange;
        font-weight: bold;
      }

      .makeGreen {
        color: green;
        font-weight: bold;
      }

      .warning {
        font-weight: bold;
      }
      .danger_ng {
        color: red;
      }
      .highrisk {
        text-decoration: underline;
      }
    `,
  ],
})
export class AppComponent {
  title = 'myapp';
  foodWarning!: Boolean;
  greenChecked!: Boolean;
  doesNotExercise = false;
  over55 = false;

  property1 = true;
  property2 = false;
  property3 = true;
  myClasses = {
    warning: this.property1,
    danger: this.property2,
    highrisk: this.property3,
  };

  myClasses_2 = {
    warning: true,
    danger: true,
  };

  myStyles = {
    color: 'blue',
    'font-weight': 'bold',
  };

  myWeight = 'bold';

  constructor() {
    // Set default value to false.
    this.foodWarning = false;
    this.greenChecked = false;
  }

  adjustCSS() {}
}
