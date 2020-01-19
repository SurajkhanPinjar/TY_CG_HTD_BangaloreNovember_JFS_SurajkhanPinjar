import { Component, OnInit } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  message: string;
  constructor(private productService: ProductService ) { }

  ngOnInit() {
  }

  addProduct(form: NgForm) {
    this.productService.postData(form.value).subscribe(data => {
        console.log(data);
        this.message = data.message;

        setTimeout(() => {
          this.message = null;
        }, 2000);
        form.reset();
      }, err => {
        console.log(err);
      });
  }
}
