import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddContentComponent } from './add-content/add-content.component';
import { AppComponent } from './app.component';
import { AuthGuard } from './auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {
    path:'',
    component:AppComponent
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'dashboard',
    canActivate:[AuthGuard],
    component:DashboardComponent
  },
  {
    path:'addContent',
    canActivate:[AuthGuard],
    component:AddContentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
