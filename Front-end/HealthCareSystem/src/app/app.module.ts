import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewAppointmemtComponent } from './view-appointmemt/view-appointmemt.component';
import { MakeAppointmentComponent } from './make-appointment/make-appointment.component';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component'
import { FormsModule} from '@angular/forms';
import { AppointmentDetailsComponent } from './appointment-details/appointment-details.component';
import { CenterDetailsComponent } from './center-details/center-details.component';
import { DateTimeComponent } from './date-time/date-time.component';
import { DatePipe } from '@angular/common';
@NgModule({
  declarations: [
    AppComponent,
    ViewAppointmemtComponent,
    MakeAppointmentComponent,
    ApproveAppointmentComponent,
    PageNotFoundComponent,
    AppointmentDetailsComponent,
    CenterDetailsComponent,
    DateTimeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,HttpClientModule,FormsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
