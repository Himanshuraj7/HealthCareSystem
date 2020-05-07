import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewCenterComponent } from './view-center/view-center.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { UpdateCenterComponent } from './update-center/update-center.component';
import { CenterDetailsComponent } from './center-details/center-details.component';
import { AddTestComponent } from './add-test/add-test.component';



const routes: Routes = [
  { path: '', redirectTo: 'view', pathMatch: 'full' },
  {path:'view', component:ViewCenterComponent},
  {path:'add', component:AddCenterComponent},
  {path:'update/:centerId', component:UpdateCenterComponent},
  {path:'details/:centerId', component:CenterDetailsComponent},
  {path:'addTests/:centerId', component:AddTestComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
