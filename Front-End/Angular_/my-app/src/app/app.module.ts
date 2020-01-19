import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponents } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SectionsComponent } from './sections/sections.component';
import { HomeComponent } from './home/home.component';
import { ContactusComponent } from './contactus/contactus.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { KhanComponent } from './khan/khan.component';
import { SaifComponent } from './saif/saif.component';
import { OmkarComponent } from './omkar/omkar.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponents,
    FooterComponent,
    SectionsComponent,
    HomeComponent,
    ContactusComponent,
    RegisterComponent,
    LoginComponent,
    AboutComponent,
    PageNotFoundComponent,
    KhanComponent,
    SaifComponent,
    OmkarComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent},
      { path: 'about', component: AboutComponent, children :[
        {path:'khan', component: KhanComponent},
        {path: 'saif', component: SaifComponent},
        {path: 'omkar', component: OmkarComponent}
      ]},

      { path: 'contact-us', component: ContactusComponent},
      { path: 'register', component: RegisterComponent},
      { path: 'login', component: LoginComponent},
      { path: '**', component: PageNotFoundComponent}

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
