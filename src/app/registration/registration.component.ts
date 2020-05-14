import { Component, OnInit, ViewChild } from '@angular/core';
import { Customer } from '../class';
import { ManagementService } from '../management.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  @ViewChild('customerForm', { static: false }) customerForm: NgForm;

  unamePattern = "^[A-Za-z]+([\ A-Za-z]+){4,15}$";
  mobnumPattern = "[0-9]{10}$";
  aadharPattern = "^[0-9]{12}";
  panPattern = "^[a-z0-9]{10}$";
  statePattern = "^[A-Za-z]+([\ A-Za-z]+){4,15}$";
  countryPattern = "^[A-Za-z]+([\ A-Za-z]+){4,15}$";
  datePattern = "^[0-9]{2}[-][0-9]{2}[-][0-9]{2}$";
  genderPattern = "^(?:male|Male|female|Female)$";
  isValidFormSubmitted = false;
  customer: Customer = new Customer();
  message: any;
  heading = false;

  constructor(private service: ManagementService) { }

  ngOnInit(): void {
  }
  public registerNow(form: NgForm) {
    this.isValidFormSubmitted = false;
    if (form.invalid) {
      return;
    }

    this.customer = form.value;
    let resp = this.service.doRegistration(this.customer);
    resp.subscribe((data) => this.message = data);
    console.log(this.customer.customerName);
    console.log(this.message);
    this.customer = new Customer();

    // if (this.customer.customerName != "") {
    //   this.heading = true;
    //   form.resetForm();
    // } else {
    //   this.heading = false;
    // }
    form.resetForm();

  }
}