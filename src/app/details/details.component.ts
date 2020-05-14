import { Component, OnInit, ViewChild } from '@angular/core';
import { ManagementService } from '../management.service';
import { Customer } from '../class';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  @ViewChild('customerForm', { static: false }) customerForm: NgForm;
  customerId: number;
  idPattern = "[0-9]{10}$";
  customer: Customer;
  submitted = false;
  check = false;
  constructor(private service: ManagementService) { }

  ngOnInit(): void {
  }

  public findCustomer() {
    this.customer = new Customer();
    //console.log(this.customerId)
    this.service.getCustomerById(this.customerId).subscribe((data) => this.customer = data);

  }

  onSubmit() {
    console.log(this.customerId)
    this.findCustomer();
    this.customerForm.resetForm();
    this.submitted = true;
  }

}
