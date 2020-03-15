import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from '../app/components/user-list/user-list.component';
import { UserCreateComponent } from '../app/components/user-create/user-create.component';

const routes: Routes = [
  { path: 'userList', component: UserListComponent },
  { path: 'userCreate', component: UserCreateComponent },
  {path: '', redirectTo: '/userList', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
