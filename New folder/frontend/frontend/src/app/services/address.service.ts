import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import {Addressinfo} from '../auth/addressinfo';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AddressService {
  private addAddr = 'http://localhost:8087/api/auth/saveAddress';
  constructor(private http: HttpClient) { }

  addAddress(addresinfo: Addressinfo): Observable<any> {
    return this.http.post<any>(this.addAddr,addresinfo , httpOptions);
  }
  
}
