import { Component, OnInit } from '@angular/core';
import { EmailValidator, FormControl, FormGroup, Validators } from '@angular/forms';
// import { Console } from 'console';
import { UservalidationService } from '../service/uservalidation.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userValidation: UservalidationService) { }

  signupForm: FormGroup;
  ngOnInit(): void {
    this.signupForm=new FormGroup({
      password: new FormControl(null, Validators.required), 
      name: new FormControl(null, Validators.required), //Note we can add more than one validator, if we have email we can add validator for the email.
      email: new FormControl(null, Validators.required)
    });
  }

  onSubmit(): void {
    console.log(this.signupForm.value);
    this.userValidation.insertUser(this.signupForm.value).subscribe(data=>{
        console.log(data);
    });
    
  }
}
