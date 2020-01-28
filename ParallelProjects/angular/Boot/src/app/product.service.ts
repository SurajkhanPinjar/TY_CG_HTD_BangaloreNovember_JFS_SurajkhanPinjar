import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  addProducts(productDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-products`, productDetails);
  } 

  getAllProducts(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-all-product`);
  }

  deleteProducts(products: Products) {
    return this.http.delete<any>(`${this.url}/delete-product/${products.productId}`);
  }

  updateProduct(product) {
    return this.http.put<any>(`${this.url}/modify-product`, product);
  }
  

}
