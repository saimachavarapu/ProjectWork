import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentbookingComponent } from './appointmentbooking/appointmentbooking.component';
import { AppointmentstatusComponent } from './appointmentstatus/appointmentstatus.component';
import { BookedappointmentsComponent } from './bookedappointments/bookedappointments.component';
import { DepartmentdoctorsComponent } from './departmentdoctors/departmentdoctors.component';
import { DoctorviewComponent } from './doctorview/doctorview.component';
import { FirstpageComponent } from './firstpage/firstpage.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { SpecializationsComponent } from './specializations/specializations.component';

const routes: Routes = [
  {'path':'register', component:RegisterComponent},
  {'path':'login', component:LoginComponent},
  {'path':'', component:HomepageComponent},
  {'path':'firstpage', component:FirstpageComponent},
  {'path':'specialization', component:SpecializationsComponent},
  {'path': 'doctorsinspecialization', component: DepartmentdoctorsComponent},
  {'path': 'viewdoctordata', component: DoctorviewComponent},
  {'path': 'logout', component: LogoutComponent},
  {'path': 'bookappointment', component: AppointmentbookingComponent},
  {'path': 'appointmentStatus', component: AppointmentstatusComponent},
  {'path': 'bookedappointments', component: BookedappointmentsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
