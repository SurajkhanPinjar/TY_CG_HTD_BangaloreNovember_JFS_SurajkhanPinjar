import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-products',
  templateUrl: './get-all-products.component.html',
  styleUrls: ['./get-all-products.component.css']
})
export class GetAllProductsComponent implements OnInit {

  success: string;
  failure: string;
  products: Products[];

  constructor(private productDetails: ProductService,
              private router: Router) { 
                 this.getAllProducts(); 
              }

  ngOnInit() {
  }

  deleteProducts(product: Products){
    this.productDetails.deleteProducts(product).subscribe(data =>{
      console.log(data);
      if(data.statusCode === 201){
        this.products.splice(this.products.indexOf(product),1);
        this.success = data.message;
      }
    })
  }

  updateProduct(product) {
    this.router.navigate([`update-product/${product.productId}`],
    { queryParams: { 
                    productName: product.productName,
                    quantity: product.quantity
                  }});
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
