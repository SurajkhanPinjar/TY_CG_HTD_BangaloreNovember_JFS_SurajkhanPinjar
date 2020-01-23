import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AdminComponent } from './admin/admin.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { GetAllCustomerComponent } from './get-all-customer/get-all-customer.component';
import { AddContractsClientComponent } from './add-contracts-client/add-contracts-client.component';
import { GetAllContractsComponent } from './get-all-contracts/get-all-contracts.component';
import { AddProductsComponent } from './add-products/add-products.component';
import { GetAllProductsComponent } from './get-all-products/get-all-products.component';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
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
import { AuthGuardService } from './auth-guard.service';
import { GetAllContractsSchedulerComponent } from './get-all-contracts-scheduler/get-all-contracts-scheduler.component';
import { GetAllProductClientComponent } from './get-all-product-client/get-all-product-client.component';
import { ClientNavComponent } from './client-nav/client-nav.component';
import { SchedulerNavComponent } from './scheduler-nav/scheduler-nav.component';
import { AddContractsComponent } from './add-contracts/add-contracts.component';
import { AddCustomerClientComponent } from './add-customer-client/add-customer-client.component';
import { GetAllProductsSchedulerComponent } from './get-all-products-scheduler/get-all-products-scheduler.component';
import { GetAllCustomerClientComponent } from './get-all-customer-client/get-all-customer-client.component';
import { UpdateCustomerClientComponent } from './update-customer-client/update-customer-client.component';
import { UpdateContractsClientComponent } from './update-contracts-client/update-contracts-client.component';
import { GetAllContractsClientComponent } from './get-all-contracts-client/get-all-contracts-client.component';



const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'login', component: LoginComponent},
  { path: 'client-login', component: ClientLoginComponent},
  { path: 'scheduler-login', component: SchedulerLoginComponent},
  { path: 'admin-nav', component: AdminNavComponent}, 
  { path: 'register', component: RegisterComponent},
  { path: 'add-accounts', component: AddAccountsComponent},
  { path: 'add-customer', component: AddCustomerComponent},
  { path: 'add-customer-client', component: AddCustomerClientComponent},
  { path: 'search-customer', component: SearchCustomerComponent},
  { path: 'update-customer/:customerId', component: UpdateCustomerComponent},
  { path: 'update-customer-client/:customerId', component: UpdateCustomerClientComponent},
  { path: 'get-all-customer', component: GetAllCustomerComponent},
  { path: 'get-all-customer-client', component: GetAllCustomerClientComponent},
  { path: 'add-contracts', component: AddContractsComponent},
  { path: 'add-contracts-client', component: AddContractsClientComponent},
  { path: 'get-all-contracts', component: GetAllContractsComponent},
  { path: 'get-all-contracts-client', component: GetAllContractsClientComponent},
  { path: 'get-all-contracts-scheduler', component: GetAllContractsSchedulerComponent},
  { path: 'update-contract/:contractNo', component: UpdateContractComponent},
  { path: 'update-contract-client/:contractNo', component: UpdateContractsClientComponent},
  { path: 'schedule-contract/:contractNo', component: ScheduleContractsComponent},
  { path: 'search-contracts', component: SearchContractsComponent},
  { path: 'add-products', component: AddProductsComponent},
  { path: 'get-all-products', component: GetAllProductsComponent},
  { path: 'get-all-products-client', component: GetAllProductClientComponent},
  { path: 'get-all-products-scheduler', component: GetAllProductsSchedulerComponent},
  { path: 'update-product/:productId', component: UpdateProductComponent},
  { path: 'search-products', component: SearchProductsComponent},
  { path: 'add-land', component: AddLandComponent},
  { path: 'get-all-land', component: GetAllLandComponent},
  { path: 'schedule-contract/:contractNo', component: ScheduleContractsComponent},
  {path: 'nav-admin', component: AdminNavComponent},
  {path: 'nav-client', component: ClientNavComponent},
  {path: 'nav-scheduler', component: SchedulerNavComponent},
  {path: 'admin',  component: AdminComponent, canActivate: [AuthGuardService],
  data: {role: 'admin'}},
  {path: 'client', component: ClientComponent, canActivate: [AuthGuardService],
  data: {role: 'client'} },
  { path: 'scheduler', component: SchedulerComponent, canActivate: [AuthGuardService],
  data: {role: 'scheduler'}},
  {path: '**', component: PageNotFoundComponent}  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
