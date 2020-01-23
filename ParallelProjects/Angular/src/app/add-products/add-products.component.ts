import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css']
})
export class AddProductsComponent implements OnInit {

  constructor(private product: ProductService) { }

  success: string;
  failure: string;
  // form : FormGroup;
 
  

  addProducts(form: NgForm) {
    this.product.addProducts(form.value).subscribe(data => {
      console.log(data);

      if(data.statusCode === 201){
        this.success = data.description;
        setTimeout(() => {
          this.success = null;
        }, 2000);
        form.reset();
      } else {
        this.failure = data.description
        ;
        setTimeout(() => {
          this.failure = null;
        },2000);
      }
    });
  }

  



  ngOnInit() {
    // this.form = new FormGroup({
    //   productId: new FormControl(null, [
    //     Validators.required,
    //     Validators.pattern('[1-9]')
    //   ])
    //   // productName: new FormControl(null, [
    //   //   Validators.required,
    //   //   Validators.minLength(2)
    //   // ]),
    //   // quantity: new FormControl(null, [
    //   //   Validators.required
    //   // ])
    // });

  }

  // registerForm: FormGroup;
  // ngOnInit() {
  //   this.registerForm = new FormGroup({
  //     name: new FormControl(null, [
  //       Validators.required,
  //       Validators.minLength(5)
  //     ]),
  //     email: new FormControl(null, [
  //       Validators.required,
  //       Validators.minLength(8),
  //       Validators.email
  //     ]),
  //     password: new FormControl(null, [
  //       Validators.required,
  //       Validators.minLength(8)
  //     ]),
  //     age: new FormControl(null, [
  //       Validators.required,
  //       Validators.maxLength(3),
  //       Validators.pattern('[0-9]'),
  //       Validators.min(1),
  //       Validators.max(150)
  //     ]),
  //     skills: new FormArray([
  //       // Hard Coded 
  //       // new FormControl(),
  //       // new FormControl(),
  //       // new FormControl()
  //       this.getSkill()
  //     ])
  //   });

}
