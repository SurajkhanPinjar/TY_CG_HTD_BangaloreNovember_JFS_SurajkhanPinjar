import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, NgForm, FormArray } from '@angular/forms';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor() { }

  registerForm: FormGroup;
  ngOnInit() {
    this.registerForm = new FormGroup({
      name: new FormControl(null, [
        Validators.required,
        Validators.minLength(5)
      ]),
      email: new FormControl(null, [
        Validators.required,
        Validators.minLength(8),
        Validators.email
      ]),
      password: new FormControl(null, [
        Validators.required,
        Validators.minLength(8)
      ]),
      age: new FormControl(null, [
        Validators.required,
        Validators.maxLength(3),
        Validators.pattern('[0-9]'),
        Validators.min(1),
        Validators.max(150)
      ]),
      skills: new FormArray([
        // Hard Coded 
        // new FormControl(),
        // new FormControl(),
        // new FormControl()
        this.getSkill()
      ])
    });

    console.log(this.registerForm.get('skills'));
  }


  submitForm() {
    console.log(this.registerForm);
    this.registerForm.reset();   //Reset The Values After Register
  }

  //To have  new FormControl Object (skill)
  getSkill() {
    return new FormControl(null,[
      Validators.required,
      Validators.minLength(3)
    ]);
  }

  //To Push FormControl (skill) to FormArray(skills)
  addSkill() {
    this.skills.push(this.getSkill());
  }

  //To delete Each Skill
  deleteSkill(i: number) {
    this.skills.removeAt(i);
  }

  //To access skills (FormArray)
  get skills(): FormArray {
    return this.registerForm.get('skills') as FormArray;
  }

  //To access Name Field
  get name() {
    return this.registerForm.get('name');
  }

  //To access Email Field
  get email() {
    return this.registerForm.get('email');
  }

  //To access password Field
  get password() {
    return this.registerForm.get('password');
  }

  //To access Age Field
  get age() {
    return this.registerForm.get('age');
  }

}
