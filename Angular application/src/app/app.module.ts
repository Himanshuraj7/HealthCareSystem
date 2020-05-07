import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewCenterComponent } from './view-center/view-center.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from  '@angular/forms';
import { UpdateCenterComponent } from './update-center/update-center.component';
import {ConfirmationPopoverModule} from 'angular-confirmation-popover';
import { CenterDetailsComponent } from './center-details/center-details.component';
import { AddTestComponent } from './add-test/add-test.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewCenterComponent,
    AddCenterComponent,
    UpdateCenterComponent,
    CenterDetailsComponent,
    AddTestComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType:'danger'
    })  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
