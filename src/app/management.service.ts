import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './class';
@Injectable({
  providedIn: 'root'
})
export class ManagementService {

  constructor(private http: HttpClient) { }
  public doRegistration(customer) {
    return this.http.post("http://localhost:8100/api/v1/addCustomer", customer, { responseType: 'text' as 'json' });
  }

  public getCustomers(): Observable<Customer> {
    return this.http.get<Customer>("http://localhost:8100/api/v1/customers");
  }

  public getCustomerById(customerId): Observable<Customer> {
    return this.http.get<Customer>("http://localhost:8100/api/v1/customer/" + customerId);
  }

  public deleteCustomer(customerId): Observable<Customer> {
    return this.http.delete<Customer>("http://localhost:8100/api/v1/delete/" + customerId);
  }
  public updateCustomer(customer): Observable<Customer> {
    return this.http.put<Customer>("http://localhost:8100/api/v1/update/", customer);
  }

  public addAccount(account) {
    return this.http.post("http://localhost:8200/api/v1/addAccount", account, { responseType: 'text' as 'json' });
  }

  public getAccounts(): Observable<Account> {
    return this.http.get<Account>("http://localhost:8200/api/v1/showAccounts");
  }

  public deleteAccount(customerId): Observable<String> {
    return this.http.delete<String>("http://localhost:8200/api/v1/deleteAccount/" + customerId);
  }

}
