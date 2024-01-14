import { CommonModule, Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormGroupDirective,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { AngularMaterialModule } from 'src/app/config/angular-material.module';
import { RegisterServiceService } from '../register-service.service';

@Component({
  selector: 'app-registe-page',
  standalone: true,
  imports: [
    AngularMaterialModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  templateUrl: './registe-page.component.html',
  styleUrls: ['./registe-page.component.css'],
})
export class RegistePageComponent implements OnInit {
  registerForm: FormGroup;
  fieldRequired: string = 'Campo obrigatório';
  constructor(
    private auth: RegisterServiceService,
    private readonly location: Location
  ) {}

  ngOnInit() {
    this.createForm();
  }
  createForm() {
    let emailregex: RegExp =
      /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    this.registerForm = new FormGroup({
      nome: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [
        Validators.required,
        Validators.pattern(emailregex),
      ]),
      password: new FormControl(null, [
        Validators.required,
        this.checkPassword,
      ]),
    });
  }
  emaiErrors() {
    return this.registerForm.get('email').hasError('required')
      ? 'Campo Requerido, utilizado para efetuar Login!'
      : this.registerForm.get('email').hasError('pattern')
      ? 'Não é um endereço de email válido.'
      : '';
  }
  checkPassword(control) {
    let enteredPassword = control.value;
    let passwordCheck = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{6,})/;
    return !passwordCheck.test(enteredPassword) && enteredPassword
      ? { requirements: true }
      : null;
  }
  getErrorPassword() {
    return this.registerForm.get('password').hasError('required')
      ? 'Campo Obrigatório (Senha com pelo menos 8 caracteres, 1 letra maiúscula e 1 minuscula)'
      : this.registerForm.get('password').hasError('requirements')
      ? '(Senha com pelo menos 8 caracteres, 1 letra maiúscula e 1  minuscula)'
      : '';
  }
  checkValidation(input: string) {
    const validation =
      this.registerForm.get(input).invalid &&
      (this.registerForm.get(input).dirty ||
        this.registerForm.get(input).touched);
    return validation;
  }
  onSubmit(formData: FormGroup, formDirective: FormGroupDirective): void {
    const email = formData.value.email;
    const password = formData.value.password;
    const nome = formData.value.nome;
    this.auth.registerUSer(email, password, nome).subscribe(() => {
      formDirective.resetForm();
      this.registerForm.reset();
      this.location.back();
    });
  }
}
