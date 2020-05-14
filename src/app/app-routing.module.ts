import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { DeleteComponent } from './delete/delete.component';
import { UpdateComponent } from './update/update.component';
import { DetailsComponent } from './details/details.component';
import { HomeComponent } from './home/home.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ManagerComponent } from './manager/manager.component';
import { AddAccountComponent } from './add-account/add-account.component';


const routes: Routes = [
  { path: "delete", component: DeleteComponent },
  { path: "update/:customerId", component: UpdateComponent },
  { path: "details", component: DetailsComponent },
  { path: "register", component: RegistrationComponent },
  { path: "aboutUs", component: AboutUsComponent },
  { path: "manager", component: ManagerComponent },
  { path: "addAccount", component: AddAccountComponent },
  { path: "", component: HomeComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
