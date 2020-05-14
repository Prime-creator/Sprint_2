import { Component, OnInit } from '@angular/core';
import { ManagementService } from '../management.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  customers: any;
  search: any;
  reponse: String;
  constructor(private service: ManagementService, private router: Router) { }

  public deleteCustomer(customerId: number) {
    let resp = this.service.deleteCustomer(customerId);
    this.service.deleteAccount(customerId).subscribe((data) => this.reponse = data);
    resp.subscribe((data) => this.customers = data);
  }

  public findCustomerById() {
    let resp = this.service.getCustomerById(this.search);
    resp.subscribe((data) => this.customers = data);
  }

  ngOnInit(): void {
    let resp = this.service.getCustomers();
    resp.subscribe((data) => this.customers = data);
  }

  customerDetails(customerId: number) {
    this.router.navigate(['details', customerId]);
  }

  updateCustomer(customerId: number) {
    this.router.navigate(['update', customerId]);
  }
  addAccount(customerId: number) {
    this.router.navigate(['addAccount', customerId]);
  }

}
