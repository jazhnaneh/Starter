import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule , ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { NgModule} from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserCreateComponent } from './components/user-create/user-create.component';
import {ToastrModule} from 'ngx-toastr';




@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserCreateComponent,
  ],


  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ToastrModule.forRoot({
      timeOut: 5000,
      positionClass: 'toast-center-center',
      preventDuplicates: false,
      progressBar: true,
      newestOnTop: true,
      closeButton: true,
      enableHtml: true,
      maxOpened: 5,
    }),
  ],
  providers: [
  ],

  bootstrap: [AppComponent],

  entryComponents: [
  ]

})
export class AppModule { }
