import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './components/beforeLogin/LoginPage/LoginPage.component';
import { NavComponent } from './components/layout/nav/nav.component';
import { AuthGuard } from './config/AuthGuard.guard';

const routes: Routes = [
  { path: '', component: NavComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
