import { Injectable } from '@angular/core';
import { HttpClient,HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Http, Response } from '@angular/http';  
import { Observable, of, throwError, pipe} from "rxjs"
import { map, filter, catchError, mergeMap } from 'rxjs/operators';
import { AuthenticationService } from './authentication.service';
import { Product } from '../models/product';
import {Producdto} from '../auth/producdto'



@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public listAllURL = 'http://localhost:8087/api/auth/all';
  public add = 'http://localhost:8087/api/auth/addToCart';
  public  delProd = 'http://localhost:8087/api/auth/product/delete';
  

  constructor(private httpClient:HttpClient, private authService:AuthenticationService) {
    this.httpClient = httpClient;
   }

   saveProduct(formData: FormData): Observable <any>
   {


       return this.httpClient.post<any>('http://localhost:8087/api/auth/saveProduct', formData);
   }



   deleteProduct(id: number): Observable<any> {
    return this.httpClient.delete(`${this.delProd}/${id}`);
  } 



  
  getAllProducts ()
  {
    return this.httpClient.get(this.listAllURL)
    .pipe(
      map(res => res),
       catchError( this.errorHandler)
      );
  }
  addProductToCart(prodcuts: any) {
    localStorage.setItem("product", JSON.stringify(prodcuts));
    //return this.httpClient.post(this.add, prodcuts);
  }
  getProductFromCart() {
    //return localStorage.getItem("product");
    return JSON.parse(localStorage.getItem('product'));
  }
  removeAllProductFromCart() {
    return localStorage.removeItem("product");
  }
  errorHandler(error: Response) {  
    console.log(error);  
    return throwError(error);  
} 
}
