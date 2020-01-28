import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { GetAllCustomerComponent } from './get-all-customer/get-all-customer.component';
import { AddContractsClientComponent } from './add-contracts-client/add-contracts-client.component';
import { GetAllContractsComponent } from './get-all-contracts/get-all-contracts.component';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
import { AddProductsComponent } from './add-products/add-products.component';
import { GetAllProductsComponent } from './get-all-products/get-all-products.component';
import { SearchContractsComponent } from './search-contracts/search-contracts.component';
import { SearchProductsComponent } from './search-products/search-products.component';
import { AddAccountsComponent } from './add-accounts/add-accounts.component';
import { AddLandComponent } from './add-land/add-land.component';
import { ClientComponent } from './client/client.component';
import { SchedulerComponent } from './scheduler/scheduler.component';
import { GetAllLandComponent } from './get-all-land/get-all-land.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ClientLoginComponent } from './client-login/client-login.component';
import { SchedulerLoginComponent } from './scheduler-login/scheduler-login.component';
import { UpdateContractComponent } from './update-contract/update-contract.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { ScheduleContractsComponent } from './schedule-contracts/schedule-contracts.component';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { GetAllContractsSchedulerComponent } from './get-all-contracts-scheduler/get-all-contracts-scheduler.component';
import { GetAllProductClientComponent } from './get-all-product-client/get-all-product-client.component';
import { ClientNavComponent } from './client-nav/client-nav.component';
import { SchedulerNavComponent } from './scheduler-nav/scheduler-nav.component';
import { AddContractsComponent } from './add-contracts/add-contracts.component';
import { AddCustomerClientComponent } from './add-customer-client/add-customer-client.component';
import { GetAllProductsSchedulerComponent } from './get-all-products-scheduler/get-all-products-scheduler.component';
import { GetAllCustomerClientComponent } from './get-all-customer-client/get-all-customer-client.component';
import { UpdateCustomerClientComponent } from './update-customer-client/update-customer-client.component';
import { GetAllContractsClientComponent } from './get-all-contracts-client/get-all-contracts-client.component';
import { UpdateContractsClientComponent } from './update-contracts-client/update-contracts-client.component';
import { UpdateLandComponent } from './update-land/update-land.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    AdminComponent,
    FooterComponent,
    PageNotFoundComponent,
    AddCustomerComponent,
    GetAllCustomerComponent,
    AddContractsClientComponent,
    GetAllContractsComponent,
    SearchCustomerComponent,
    AddProductsComponent,
    GetAllProductsComponent,
    SearchContractsComponent,
    SearchProductsComponent,
    AddAccountsComponent,
    AddLandComponent,
    ClientComponent,
    SchedulerComponent,
    GetAllLandComponent,
    UpdateProductComponent,
    ClientLoginComponent,
    SchedulerLoginComponent,
    UpdateContractComponent,
    UpdateCustomerComponent,
    ScheduleContractsComponent,
    AdminNavComponent,
    GetAllContractsSchedulerComponent,
    GetAllProductClientComponent,
    ClientNavComponent,
    SchedulerNavComponent,
    AddContractsComponent,
    AddCustomerClientComponent,
    GetAllProductsSchedulerComponent,
    GetAllCustomerClientComponent,
    UpdateCustomerClientComponent,
    GetAllContractsClientComponent,
    UpdateContractsClientComponent,
    UpdateLandComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
