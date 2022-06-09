// Directive allows use of the @Directive decorator.
// ElementRef allows access to element in HTML.
import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  // Name of the attribute.
  selector: '[myHighlight]',
})
export class HighlightDirective {
  // Pass color from 'myHighlight' atttribute to 'highlightColor' model.

  constructor(private el: ElementRef) {}

  @Input('myHighlight') highlightColor?: string;

  @HostListener('mouseenter') onMouseEnter() {
    this.highlight(this.highlightColor || 'red');
    this.color('blue');
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.highlight('');
    this.color('black');
  }

  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }

  private color(color: string) {
    this.el.nativeElement.style.color = color;
  }
}
