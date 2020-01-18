import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[];

  constructor(private http: HttpClient) {
    this.getProductFromJSON();
  }

  getProductFromJSON() {
    this.http.get<Product[]>('../../assets/products.json').subscribe(response => {
      console.log(response);
      this.products = response;
    });
  }

  ngOnInit() {
  }

}
