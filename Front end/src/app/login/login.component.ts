import { Component, OnInit } from '@angular/core';
import { EmailValidator, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
// import { Console } from 'console';
import { UservalidationService } from '../service/uservalidation.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  signupForm: FormGroup;
  constructor(private userValidation: UservalidationService, private router: Router) { }

  ngOnInit(): void {
    this.signupForm=new FormGroup({
      password: new FormControl(null, Validators.required), 
      name: new FormControl(null, Validators.required), //Note we can add more than one validator, if we have email we can add validator for the email.
      email: new FormControl(null, Validators.required)
    });
  }

  message:String;
  success:String;
  onSubmit(): void {
    console.log(this.signupForm.value);
    this.userValidation.getUser(this.signupForm.value).subscribe(data=>{
        if(data==null) {
          this.message="Invalid Credentials";
          this.success="";
        }
        else {
          this.message="";
          localStorage.setItem("userId", data.id.toString());
          localStorage.setItem("userName", data.name);
          this.success=localStorage.getItem("userName")+" is valid user";
          console.log(data);
          this.router.navigate(['/firstpage']);
          
        }
    });
  }
}
