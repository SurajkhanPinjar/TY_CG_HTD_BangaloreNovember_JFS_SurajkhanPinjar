import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  productId1;
  productName1;
  quantity1;
  
  constructor(private productDetails: ProductService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
                activatedRoute.params.subscribe( data => {
                  console.log(data.productId);
                  this.productId1 = data.productId;
                });

                activatedRoute.queryParams.subscribe( data => {
                  console.log(data);
                  this.productName1 = data.productName;
                  this.quantity1 = data.quantity;
                });
               }

  ngOnInit() {
  }

  updateProduct(form: NgForm) {
    console.log(form.value);
    this.productDetails.updateProduct(form.value).subscribe( data => {
      console.log(data);
      this.router.navigateByUrl('/get-all-products');
    });
  }

}
