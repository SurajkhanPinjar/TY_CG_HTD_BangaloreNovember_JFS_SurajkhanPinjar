import { Directive, ElementRef, Renderer2, HostListener, HostBinding } from '@angular/core';

@Directive({
  selector: '[appColor]'
})
export class ColorDirective {


  // Custom Directive
  constructor(private el: ElementRef) {
    this.el.nativeElement.style.background = 'orange';
    this.el.nativeElement.style.fontSize = '30px'
  }

  //Renderer2
  // constructor(private el: ElementRef, private renderer: Renderer2) { 
  //   let h1 = this.renderer.createElement('h1');
  //   let text = this.renderer.createText('Hello from Custome Directive');
  //   this.renderer.appendChild(h1, text);
  //   this.renderer.appendChild(this.el.nativeElement, h1);
  // }

  // @HostListener('mouseenter')
  // x() {
  //   this.el.nativeElement.style.background = '#ccc';
  //   this.el.nativeElement.style.color = 'red';
  //   this.el.nativeElement.style.fontSize = '25px';
  // }

  // @HostListener('mouseleave')
  // y() {
  //   this.el.nativeElement.style.background = 'lightblue';
  //   this.el.nativeElement.style.color = 'black';
  //   this.el.nativeElement.style.fontSize = '16px';
  // }

  @HostBinding('style.background') backgroudColor: string;
  @HostBinding('style.color') colorText: string;
  // @HostBinding('style.fontSize') fontSizes : string;
  //Instead of giving Full line we can import lines for HostBinding
  @HostListener('mouseenter')
  x() {
    this.backgroudColor = '#ccc';
    this.colorText = 'grey';
    this.el.nativeElement.style.fontSize = '25px';
    
  }
  
  @HostListener('mouseleave')
  y() {
    this.backgroudColor = 'lightblue';
    this.colorText = 'black';
    this.el.nativeElement.style.fontSize = '16px';
    

  }
}