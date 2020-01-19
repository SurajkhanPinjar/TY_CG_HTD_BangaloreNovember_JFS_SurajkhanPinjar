import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
//   product = [
//     {
//         name: 'Iphone',
//         image: 'https://cdn.pixabay.com/photo/2016/11/29/05/08/apple-1867461__340.jpg',
//         price: 42999
//     }, {
//         name: 'MacbooK',
//         image: 'https://cdn.pixabay.com/photo/2014/05/02/21/50/home-office-336378__34.jpg',
//         price: '59999'
//     }, {
//         name: 'Canon DSLR',
//         image: 'https://cdn.pixabay.com/photo/2017/04/22/10/44/camera-2251051__340.jp',
//         price: '31999'
//     }, {
//         name: 'Boat Headset',
//         image: 'https://cdn.pixabay.com/photo/2015/03/26/09/58/headphones-690685__340.jpg',
//         price: '1599'
//     },
//     {
//         name: 'Virtua Reality Play',
//         image: 'https://cdn.pixabay.com/photo/2017/02/10/14/10/virtual-2055227__340.jpg',
//         price: '6299'
//     }
// ]

message;
constructor(private data: DataService)  { }

  product = this.data.product;

deleteProducts(product) {
  this.product.splice(this.product.indexOf(product), 1);
  this.message = `${product.name} is deleted`;
}

click() {
  this.message = null;
}


  ngOnInit() {
  }

}
