import { Component, Input } from '@angular/core';
import { ActivationEnd } from '@angular/router';

export class PlayingCard {
  cardVal?: string;
  suit?: string;
}

@Component({
  selector: 'app-root',
  template: `<h1>Hello World! This is {{ title }}!</h1>
    <br />
    <h2>{{ card.cardVal }} of {{ card.suit }}!</h2>
    <br />
    <h2>Card: <input [(ngModel)]="card.cardVal" /></h2>
    <h2>Suit: <input [(ngModel)]="card.suit" /></h2>
    <br />
    <h2>Testing ngFor</h2>
    <table>
      <tr *ngFor="let c of cards">
        <td>
          <ul>
            <li>{{ c.cardVal }}</li>
          </ul>
        </td>
        <td>
          <ul>
            <li>{{ c.suit }}</li>
          </ul>
        </td>
      </tr>
    </table>
    <h2>Testing ngFor with index</h2>
    <ul *ngFor="let name of firstNames; let i = index">
      <li>Name {{ i }}: {{ name }}</li>
    </ul>
    <h2>onClick directive example</h2>
    <input [(ngModel)]="myInput" />
    <input type="button" (click)="doSomething(myInput)" />
    {{ myOutput }}
    <br />
    <h2>Second onClick directive example</h2>
    <input [(ngModel)]="myInput2" />
    <input type="button" (click)="doAnotherThing(myInput2)" />
    {{ myOutput2 }}
    <h2>ngIf example</h2>
    <h3>Hello World! This is {{ title }}</h3>
    <ul>
      <li *ngFor="let c of cards" (click)="onSelect(c)">{{ c.cardVal }}</li>
    </ul>
    <div *ngIf="selectedCard">
      <h3>{{ selectedCard.cardVal }} selected!! **</h3>
      <input [(ngModel)]="selectedCard.cardVal" placeholder="name" />
    </div>
    <br /><br />
    <section>
      <form #myForm="ngForm">
        Name:
        <input
          type="text"
          pattern="[a-zA-Z ]*"
          minlength="3"
          required
          [(ngModel)]="myName"
          name="firstName"
          #firstName="ngModel"
        />
        <div [hidden]="firstName.valid || firstName.pristine">
          This control is invalid.
        </div>
        <p *ngIf="firstName?.errors?.['required']">This field is required.</p>
        <p *ngIf="firstName?.errors?.['pattern']">
          Only alphabetical characters are allowed.
        </p>
        <p *ngIf="firstName?.errors?.['minlength']">
          This entry must have at least three characters.
        </p>
        <button
          type="submit"
          class="btn btn-default"
          [disabled]="!myForm.form.valid"
          (click)="onSubmit()"
        >
          Submit
        </button>
        <br />
        LastName:
        <input
          type="text"
          pattern="[a-zA-Z ]*"
          minlength="2"
          required
          [(ngModel)]="myLastName"
          name="LastName"
          #LastName="ngModel"
        />
        <div [hidden]="LastName.valid || LastName.pristine">
          This control is invalid.
        </div>
        <p *ngIf="LastName?.errors?.['required']">This field is required.</p>
        <p *ngIf="LastName?.errors?.['pattern']">
          Only alphabetical characters are allowed.
        </p>
        <p *ngIf="LastName?.errors?.['minlength']">
          This entry must have at least three characters.
        </p>
        <button
          type="submit"
          class="btn btn-default"
          [disabled]="!myForm.form.valid"
          (click)="onSubmit()"
        >
          Submit
        </button>
      </form>
    </section>`,
})
export class AppComponent {
  title = 'myapp';
  lastName = 'Doan';
  firstNames = ['Tam', 'Maria', 'Maru'];
  myInput = '';
  myOutput = '';
  myInput2 = '';
  myOutput2 = '';
  myName = 'Tam';
  myLastName = 'Doan';

  constructor() {
    this.myName = 'Maria';
    this.myLastName = '';
  }

  onSubmit() {
    alert(this.myName);
    alert(this.myLastName);
  }

  card: PlayingCard = {
    cardVal: 'Queen',
    suit: 'Spades',
  };

  card2: PlayingCard = {
    cardVal: 'Queen',
    suit: 'Diamonds',
  };

  cards: PlayingCard[] = [
    { cardVal: 'Ace', suit: 'Spades' },
    { cardVal: 'King', suit: 'Spades' },
    { cardVal: 'Queen', suit: 'Spades' },
    { cardVal: 'Jack', suit: 'Spades' },
  ];

  selectedCard?: PlayingCard;

  onSelect(card: PlayingCard) {
    alert(card.suit);
    this.selectedCard = card;
  }
  doSomething(someContent: string) {
    alert(someContent);
    this.myOutput = someContent;
  }

  doAnotherThing(someContent: string) {
    alert(someContent);
    this.myOutput2 = someContent;
  }
}
