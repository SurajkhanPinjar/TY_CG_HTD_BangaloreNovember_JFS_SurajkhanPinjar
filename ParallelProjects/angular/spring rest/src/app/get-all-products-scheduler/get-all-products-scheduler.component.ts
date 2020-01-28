import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-products-scheduler',
  templateUrl: './get-all-products-scheduler.component.html',
  styleUrls: ['./get-all-products-scheduler.component.css']
})
export class GetAllProductsSchedulerComponent implements OnInit {

  success: string;
  failure: string;
  products: Products[];

  constructor(private productDetails: ProductService,
              private router: Router) { 
                this.getAllProducts(); 
              }

  ngOnInit() {
  }

  getAllProducts() {
    this.productDetails.getAllProducts().subscribe(response =>{
      console.log(response);
      if(response.statusCode === 201) {
        this.products = response.productResponse;
        this.success = response.description;
        localStorage.setItem('Product Details', JSON.stringify(response));
        setTimeout(() => {
          this.success = null;
        }, 2000);
      } else {
        this.failure = response.description;
        localStorage.setItem('Product Details', JSON.stringify(response));
        console.log('Product Details are founded');
        setTimeout(() => {
          this.failure = null;
        }, 3000);
      }
    })
  }

}
