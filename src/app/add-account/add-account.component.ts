import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Account } from '../Account';
import { ManagementService } from '../management.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {
  @ViewChild('accountForm', { static: false }) accountForm: NgForm;
  message: any;
  account: Account;
  submitted: boolean = false;
  amountPattern = "[0-9]{5,10}$";
  accountTypePattern = "^(?:saving|Saving|Loan|loan|current|Current)$";
  cutomerIdPattern = "[0-9]{8}$";

  constructor(private service: ManagementService) { }

  ngOnInit(): void {
    this.account = new Account();

  }
  AddAccount(account: Account) {
    let resp = this.service.addAccount(account);
    resp.subscribe((data) => this.message = data);
    this.submitted = true;
    this.account = new Account();
  }
  onSubmit() {
    this.AddAccount(this.account);
    this.accountForm.resetForm();
  }

}
