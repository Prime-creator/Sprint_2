import { Component, OnInit, ViewChild } from '@angular/core';
import { ManagementService } from '../management.service';
import { Customer } from '../class';
import { ActivatedRouteSnapshot, Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  @ViewChild('customerForm', { static: false }) customerForm: NgForm;

  unamePattern = "^[A-Za-z]+([\ A-Za-z]+){4,15}$";
  mobnumPattern = "[0-9]{10}$";
  aadharPattern = "^[0-9]{12}";
  panPattern = "^[a-z0-9]{10}$";
  statePattern = "^[A-Za-z]+([\ A-Za-z]+){4,15}$";
  countryPattern = "^[A-Za-z]+([\ A-Za-z]+){4,15}$";
  datePattern = "^[0-9]{2}[-][0-9]{2}[-][0-9]{2}$";
  submitted = false;

  customerId: number;
  customer: Customer;

  constructor(private route: ActivatedRoute, private router: Router, private service: ManagementService) { }

  ngOnInit(): void {
    this.customer = new Customer();

    this.customerId = this.route.snapshot.params['customerId'];
    this.service.getCustomerById(this.customerId).subscribe((data) => this.customer = data);
  }
  public updateCustomer(customer: Customer) {
    console.log(JSON.stringify(customer));
    let resp = this.service.updateCustomer(customer).subscribe(data => customer = data);
    this.customer = new Customer();
  }

  onSubmit() {
    this.updateCustomer(this.customer);
    this.submitted = true;
    this.customerForm.resetForm();
  }

}
