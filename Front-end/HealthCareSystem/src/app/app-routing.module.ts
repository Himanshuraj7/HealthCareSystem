import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MakeAppointmentComponent } from './make-appointment/make-appointment.component';
import { ViewAppointmemtComponent } from './view-appointmemt/view-appointmemt.component';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AppointmentDetailsComponent } from './appointment-details/appointment-details.component';
import { CenterDetailsComponent } from './center-details/center-details.component';
import { DateTimeComponent } from './date-time/date-time.component';


const routes: Routes = [
  {path:'add',component: MakeAppointmentComponent},
  {path:'view',component: ViewAppointmemtComponent},
  {path:'approve',component: ApproveAppointmentComponent},
  {path:'details/:appointmentId',component:AppointmentDetailsComponent},
  {path:'centerDetails/:centerId',component:CenterDetailsComponent},
  {path:'dateTimeDetails/:centerId/:testId',component:DateTimeComponent},
  { path: '', redirectTo: '/approve', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
