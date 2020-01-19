import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { DataComponentsComponent } from './data-components/data-components.component';
import { LateComponent } from './late/late.component';
import { ProductsComponent } from './products/products.component';
import { ProductsImagesComponent } from './products-images/products-images.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { ColorDirective } from './color.directive';
import { ChildComponent } from './child/child.component';
import { ParentComponent } from './parent/parent.component';
import { BikesComponent } from './bikes/bikes.component';
import { BikeDetailsComponent } from './bike-details/bike-details.component';
import { CarsComponent } from './cars/cars.component';
import { CarDetailsComponent } from './car-details/car-details.component';



@NgModule({
  declarations: [
    AppComponent,
    DataComponentsComponent,
    LateComponent,
    ProductsComponent,
    ProductsImagesComponent,
    HomeComponent,
    HeaderComponent,
    ColorDirective,
    ChildComponent,
    ParentComponent,
    BikesComponent,
    BikeDetailsComponent,
    CarsComponent,
    CarDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([
      {path: '', component: HomeComponent },
      // {path: 'late', component: LateComponent },
      {path: 'products', component: ProductsComponent},
      // {path: 'products-images', component: ProductsImagesComponent  }
      {path: 'bikes', component: BikesComponent},
      {path: 'cars', component: CarsComponent},
      {path:'parent',component:ParentComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
